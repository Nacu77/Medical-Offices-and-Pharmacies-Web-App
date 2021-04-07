package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicineStockDTO {

    private int amount;
    private double price;
    private MedicineDTO medicine;

    @Builder
    public MedicineStockDTO(int amount, double price, MedicineDTO medicine) {
        this.amount = amount;
        this.price = price;
        this.medicine = medicine;
    }
}
