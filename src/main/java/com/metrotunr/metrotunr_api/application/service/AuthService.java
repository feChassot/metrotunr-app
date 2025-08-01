package com.metrotunr.metrotunr_api.application.service;

import com.metrotunr.metrotunr_api.application.dto.AuthRequest;
import com.metrotunr.metrotunr_api.application.dto.AuthResponse;
import com.metrotunr.metrotunr_api.domain.model.Role;
import com.metrotunr.metrotunr_api.domain.model.User;
import com.metrotunr.metrotunr_api.domain.repository.UserRepository;
import com.metrotunr.metrotunr_api.infrastructure.security.JwtService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Transactional
    public AuthResponse register(AuthRequest request) {
        if(userRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("Email already registered. Please try again.");
        }

        User user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.MUSICIANS)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Invalid credentials."));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials.");
        }

        String token = jwtService.generateToken(user);
        return new AuthResponse(token);
    }
}
