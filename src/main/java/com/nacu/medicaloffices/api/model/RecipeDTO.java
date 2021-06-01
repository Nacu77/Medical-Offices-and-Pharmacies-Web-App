package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecipeDTO {

    private Long id;
    private String description;
    private List<MedicineDTO> medicines;

    @Builder
    public RecipeDTO(Long id, String description, List<MedicineDTO> medicines) {
        this.id = id;
        this.description = description;
        this.medicines = medicines;
    }
}
