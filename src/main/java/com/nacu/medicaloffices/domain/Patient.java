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
public class Patient extends Person {

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Recipe> recipes = new HashSet<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();

    @Builder
    public Patient(Long id, String firstName, String lastName, ContactData contactData, Set<Recipe> recipes, Set<Appointment> appointments) {
        super(id, firstName, lastName, contactData);
        this.recipes = Objects.requireNonNullElseGet(recipes, HashSet::new);
        this.appointments = Objects.requireNonNullElseGet(appointments, HashSet::new);
    }
}
