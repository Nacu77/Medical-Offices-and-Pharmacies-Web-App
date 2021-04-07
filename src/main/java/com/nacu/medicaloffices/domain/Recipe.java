package com.nacu.medicaloffices.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Recipe extends BaseEntity {

    private String description;

    @ManyToMany
    @JoinTable(
            name = "recipe_medicine",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id")
    )
    private Set<Medicine> medicines = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Builder
    public Recipe(Long id, String description, Set<Medicine> medicines, Patient patient) {
        super(id);
        this.description = description;
        this.medicines = Objects.requireNonNullElseGet(medicines, HashSet::new);;
        this.patient = patient;
    }
}
