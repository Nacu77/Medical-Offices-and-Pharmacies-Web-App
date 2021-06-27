package com.nacu.medicaloffices.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    private String username;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacy_owner_id")
    private PharmacyOwner pharmacyOwner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @Builder
    public User(Long id, String username, String password, Doctor doctor, PharmacyOwner pharmacyOwner, Patient patient, Role role) {
        super(id);
        this.username = username;
        this.password = password;
        this.doctor = doctor;
        this.pharmacyOwner = pharmacyOwner;
        this.patient = patient;
        this.role = role;
    }
}
