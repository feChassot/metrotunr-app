package com.metrotunr.metrotunr_api.interfaces.controller;

import com.metrotunr.metrotunr_api.application.usecase.GetDefaultMetronomeSettingsUseCase;
import com.metrotunr.metrotunr_api.domain.model.MetronomeSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/metronome")
@RequiredArgsConstructor
public class MetronomeController {

    private final GetDefaultMetronomeSettingsUseCase getSettings;

    @GetMapping("/default")
    public ResponseEntity<MetronomeSettings> getDefaultSettings() {
        return ResponseEntity.ok(getSettings.execute());
    }
}
