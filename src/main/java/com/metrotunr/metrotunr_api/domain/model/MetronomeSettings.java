package com.metrotunr.metrotunr_api.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetronomeSettings {
    private int bpm;
    private int beatsPerBar;
}
