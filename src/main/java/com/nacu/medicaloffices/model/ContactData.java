package com.nacu.medicaloffices.model;

import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ContactData extends BaseEntity {

    private String phoneNumber;
    private String email;

    @Builder
    public ContactData(Long id, String phoneNumber, String email) {
        super(id);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
