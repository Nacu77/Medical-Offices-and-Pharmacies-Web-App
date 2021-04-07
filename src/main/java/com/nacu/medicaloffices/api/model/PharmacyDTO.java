package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PharmacyDTO {

    private String name;
    private ContactDataDTO contactData;
    private AddressDTO address;
    private List<MedicineStockDTO> medicinesStock;

    @Builder
    public PharmacyDTO(String name, ContactDataDTO contactData, AddressDTO address, List<MedicineStockDTO> medicinesStock) {
        this.name = name;
        this.contactData = contactData;
        this.address = address;
        this.medicinesStock = medicinesStock;
    }
}
