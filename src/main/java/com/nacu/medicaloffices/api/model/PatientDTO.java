package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PatientDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private ContactDataDTO contactData;
    private List<RecipeDTO> recipes;
    private List<AppointmentDTO> appointments;

    @Builder
    public PatientDTO(Long id, String firstName, String lastName, ContactDataDTO contactData, List<RecipeDTO> recipes, List<AppointmentDTO> appointments) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactData = contactData;
        this.recipes = recipes;
        this.appointments = appointments;
    }
}
