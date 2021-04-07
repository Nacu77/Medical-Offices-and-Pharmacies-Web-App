package com.nacu.medicaloffices.domain;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
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
