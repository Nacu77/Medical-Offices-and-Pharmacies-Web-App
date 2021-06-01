package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DoctorDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private ContactDataDTO contactData;
    private List<MedicalOfficeDTO> medicalOffices;

    @Builder
    public DoctorDTO(Long id, String firstName, String lastName, ContactDataDTO contactData, List<MedicalOfficeDTO> medicalOffices) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactData = contactData;
        this.medicalOffices = medicalOffices;
    }
}
