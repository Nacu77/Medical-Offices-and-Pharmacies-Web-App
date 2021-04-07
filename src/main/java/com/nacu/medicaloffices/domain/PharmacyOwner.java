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
public class PharmacyOwner extends Person {

    @OneToMany(mappedBy = "pharmacyOwner", cascade = CascadeType.ALL)
    private Set<Pharmacy> pharmacies = new HashSet<>();

    @Builder
    public PharmacyOwner(Long id, String firstName, String lastName, ContactData contactData, Set<Pharmacy> pharmacies) {
        super(id, firstName, lastName, contactData);
        this.pharmacies = Objects.requireNonNullElseGet(pharmacies, HashSet::new);;
    }
}
