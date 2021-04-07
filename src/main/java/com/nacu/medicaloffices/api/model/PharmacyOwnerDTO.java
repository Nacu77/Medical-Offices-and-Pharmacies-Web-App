package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PharmacyOwnerDTO {

    private String firstName;
    private String lastName;
    private ContactDataDTO contactData;
    private List<PharmacyDTO> pharmacies;

    @Builder
    public PharmacyOwnerDTO(String firstName, String lastName, ContactDataDTO contactData, List<PharmacyDTO> pharmacies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactData = contactData;
        this.pharmacies = pharmacies;
    }
}
