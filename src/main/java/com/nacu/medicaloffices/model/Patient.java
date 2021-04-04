package com.nacu.medicaloffices.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Patient extends Person {

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Recipe> recipes = new HashSet<>();

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Appointment> appointments = new HashSet<>();

    @Builder
    public Patient(String firstName, String lastName, ContactData contactData, Set<Recipe> recipes, Set<Appointment> appointments) {
        super(firstName, lastName, contactData);
        this.recipes = recipes;
        this.appointments = appointments;
    }
}
