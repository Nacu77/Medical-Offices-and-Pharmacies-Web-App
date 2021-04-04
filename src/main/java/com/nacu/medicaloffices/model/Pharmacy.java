package com.nacu.medicaloffices.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pharmacy extends BaseEntity {

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
    private Set<PharmacyMedicine> medicineStock = new HashSet<>();

    @Builder
    public Pharmacy(Long id, PharmacyOwner pharmacyOwner, ContactData contactData, Address address, Set<PharmacyMedicine> medicineStock) {
        super(id);
        this.pharmacyOwner = pharmacyOwner;
        this.contactData = contactData;
        this.address = address;
        this.medicineStock = medicineStock;
    }
}
