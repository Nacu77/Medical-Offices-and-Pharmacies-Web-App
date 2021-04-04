package com.nacu.medicaloffices.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor extends Person {

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<MedicalOffice> medicalOffices = new HashSet<>();

    @Builder
    public Doctor(String firstName, String lastName, ContactData contactData, Set<MedicalOffice> medicalOffices) {
        super(firstName, lastName, contactData);
        this.medicalOffices = medicalOffices;
    }
}
