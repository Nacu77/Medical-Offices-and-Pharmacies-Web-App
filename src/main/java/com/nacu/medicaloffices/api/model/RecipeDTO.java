package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RecipeDTO {

    private Long id;
    private Long patientId;
    private String description;
    private List<MedicineDTO> medicines;

    @Builder
    public RecipeDTO(Long id, Long patientId, String description, List<MedicineDTO> medicines) {
        this.id = id;
        this.patientId = patientId;
        this.description = description;
        this.medicines = medicines;
    }
}
