package com.nacu.medicaloffices.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Specialty extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "specialty")
    private Set<MedicalOffice> medicalOffices = new HashSet<>();

    @Builder
    public Specialty(Long id, String name, Set<MedicalOffice> medicalOffices) {
        super(id);
        this.name = name;
        this.medicalOffices = medicalOffices;
    }
}
