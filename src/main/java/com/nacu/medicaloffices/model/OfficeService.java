package com.nacu.medicaloffices.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OfficeService extends BaseEntity {

    private double price;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private MedicalOffice medicalOffice;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
}
