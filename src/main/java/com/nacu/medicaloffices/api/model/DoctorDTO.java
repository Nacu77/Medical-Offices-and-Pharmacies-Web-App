package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorDTO {

    private String firstName;
    private String lastName;
    private ContactDataDTO contactData;
    private List<MedicalOfficeDTO> medicalOffices;

    @Builder
    public DoctorDTO(String firstName, String lastName, ContactDataDTO contactData, List<MedicalOfficeDTO> medicalOffices) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactData = contactData;
        this.medicalOffices = medicalOffices;
    }
}
