package com.nacu.medicaloffices.domain;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    private String firstName;
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id")
    private ContactData contactData;

    public Person(Long id, String firstName, String lastName, ContactData contactData) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactData = contactData;
    }
}
