package com.metrotunr.metrotunr_api.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthRequest(
    @NotBlank @Email String email,
    @NotBlank String password
) {}

