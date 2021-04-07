package com.nacu.medicaloffices.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Appointment extends BaseEntity {

    private String description;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private MedicalOffice medicalOffice;

    @Builder
    public Appointment(Long id, String description, LocalDateTime date, Patient patient, MedicalOffice medicalOffice) {
        super(id);
        this.description = description;
        this.date = date;
        this.patient = patient;
        this.medicalOffice = medicalOffice;
    }
}
