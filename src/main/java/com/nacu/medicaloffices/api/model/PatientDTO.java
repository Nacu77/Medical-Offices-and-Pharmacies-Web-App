package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PatientDTO {

    private String firstName;
    private String lastName;
    private ContactDataDTO contactData;
    private List<RecipeDTO> recipes;

    @Builder
    public PatientDTO(String firstName, String lastName, ContactDataDTO contactData, List<RecipeDTO> recipes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactData = contactData;
        this.recipes = recipes;
    }
}
