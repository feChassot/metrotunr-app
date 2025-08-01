package com.metrotunr.metrotunr_api.application.usecase;

import com.metrotunr.metrotunr_api.domain.model.MetronomeSettings;
import org.springframework.stereotype.Service;

@Service
public class GetDefaultMetronomeSettingsUseCase {

    public MetronomeSettings execute() {
        return MetronomeSettings.builder()
                .bpm(100)
                .beatsPerBar(4)
                .build();
    }
}
