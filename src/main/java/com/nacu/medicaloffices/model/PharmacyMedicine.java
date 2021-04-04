package com.nacu.medicaloffices.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PharmacyMedicine extends BaseEntity {

    private int amount;
    private double price;

    @ManyToOne
    @JoinColumn(name = "pharmacy_id")
    private Pharmacy pharmacy;

    @ManyToOne
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    @Builder
    public PharmacyMedicine(Long id, int amount, double price, Pharmacy pharmacy, Medicine medicine) {
        super(id);
        this.amount = amount;
        this.price = price;
        this.pharmacy = pharmacy;
        this.medicine = medicine;
    }
}
