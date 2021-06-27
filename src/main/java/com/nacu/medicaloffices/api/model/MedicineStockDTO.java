package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicineStockDTO {

    private Long id;
    private int amount;
    private double price;
    private MedicineDTO medicine;
    private Long pharmacyId;

    @Builder
    public MedicineStockDTO(Long id, int amount, double price, MedicineDTO medicine, Long pharmacyId) {
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.medicine = medicine;
        this.pharmacyId = pharmacyId;
    }
}
