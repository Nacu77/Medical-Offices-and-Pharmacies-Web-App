package com.nacu.medicaloffices.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Doctor extends Person {

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<MedicalOffice> medicalOffices = new HashSet<>();

    @Builder
    public Doctor(Long id, String firstName, String lastName, ContactData contactData, Set<MedicalOffice> medicalOffices) {
        super(id, firstName, lastName, contactData);
        this.medicalOffices = Objects.requireNonNullElseGet(medicalOffices, HashSet::new);
    }
}
