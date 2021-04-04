package com.nacu.medicaloffices.model;

import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address extends BaseEntity {

    private String country;
    private String city;
    private String street;
    private int number;

    @Builder
    public Address(Long id, String country, String city, String street, int number) {
        super(id);
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
    }
}
