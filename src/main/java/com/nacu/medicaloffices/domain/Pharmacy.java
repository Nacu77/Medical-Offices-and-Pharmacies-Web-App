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
public class Pharmacy extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private PharmacyOwner pharmacyOwner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private ContactData contactData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
    private Set<MedicineStock> medicinesStock = new HashSet<>();

    @Builder
    public Pharmacy(Long id, String name, PharmacyOwner pharmacyOwner, ContactData contactData, Address address, Set<MedicineStock> medicineStock) {
        super(id);
        this.name = name;
        this.pharmacyOwner = pharmacyOwner;
        this.contactData = contactData;
        this.address = address;
        this.medicinesStock = Objects.requireNonNullElseGet(medicineStock, HashSet::new);;
    }
}
