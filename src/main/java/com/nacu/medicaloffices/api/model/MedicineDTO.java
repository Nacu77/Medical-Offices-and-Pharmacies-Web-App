package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicineDTO {

    private String name;

    @Builder
    public MedicineDTO(String name) {
        this.name = name;
    }
}
