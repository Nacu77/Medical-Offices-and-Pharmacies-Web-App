package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecipeDTO {

    private String description;
    private List<MedicineDTO> medicines;

    @Builder
    public RecipeDTO(String description, List<MedicineDTO> medicines) {
        this.description = description;
        this.medicines = medicines;
    }
}
