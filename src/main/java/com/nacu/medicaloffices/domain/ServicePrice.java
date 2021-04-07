package com.nacu.medicaloffices.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ServicePrice extends BaseEntity {

    private double price;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private MedicalOffice medicalOffice;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;
}
