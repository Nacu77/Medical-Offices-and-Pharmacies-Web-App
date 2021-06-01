package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PharmacyDTO {

    private Long id;
    private String name;
    private ContactDataDTO contactData;
    private AddressDTO address;
    private List<MedicineStockDTO> medicineStock;
    private Long ownerId;

    @Builder
    public PharmacyDTO(Long id, String name, ContactDataDTO contactData, AddressDTO address, List<MedicineStockDTO> medicineStock, Long ownerId) {
        this.id = id;
        this.name = name;
        this.contactData = contactData;
        this.address = address;
        this.medicineStock = medicineStock;
        this.ownerId = ownerId;
    }
}
