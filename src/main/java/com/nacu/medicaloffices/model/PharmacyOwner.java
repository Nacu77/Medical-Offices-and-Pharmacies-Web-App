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
public class PharmacyOwner extends Person {

    @OneToMany(mappedBy = "pharmacyOwner", cascade = CascadeType.ALL)
    private Set<Pharmacy> pharmacies = new HashSet<>();

    @Builder
    public PharmacyOwner(String firstName, String lastName, ContactData contactData, Set<Pharmacy> pharmacies) {
        super(firstName, lastName, contactData);
        this.pharmacies = pharmacies;
    }
}
