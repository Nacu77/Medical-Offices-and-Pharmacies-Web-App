package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpecialtyDTO {

    private String name;

    @Builder
    public SpecialtyDTO(String name) {
        this.name = name;
    }
}
