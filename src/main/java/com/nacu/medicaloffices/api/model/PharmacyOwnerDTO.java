package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PharmacyOwnerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private ContactDataDTO contactData;
    private List<PharmacyDTO> pharmacies;

    @Builder
    public PharmacyOwnerDTO(Long id, String firstName, String lastName, ContactDataDTO contactData, List<PharmacyDTO> pharmacies) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactData = contactData;
        this.pharmacies = pharmacies;
    }
}
