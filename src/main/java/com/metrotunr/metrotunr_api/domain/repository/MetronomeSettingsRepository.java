package com.metrotunr.metrotunr_api.domain.repository;

import com.metrotunr.metrotunr_api.domain.model.MetronomeSettings;

public interface MetronomeSettingsRepository {
    MetronomeSettings getSettingsByUserEmail(String email);
}
