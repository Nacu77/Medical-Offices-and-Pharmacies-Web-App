package com.nacu.medicaloffices.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private String country;
    private String city;
    private String street;
    private int number;

    @Builder
    public AddressDTO(Long id, String country, String city, String street, int number) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
    }
}
