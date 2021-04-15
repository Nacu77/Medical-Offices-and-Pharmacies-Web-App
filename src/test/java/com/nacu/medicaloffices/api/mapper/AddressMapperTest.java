package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.AddressDTO;
import com.nacu.medicaloffices.domain.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressMapperTest {

    private final Long ID = 1L;
    private final String COUNTRY = "Romania";
    private final String CITY = "Bucharest";
    private final String STREET = "Calea Grivitei";
    private final int NUMBER = 77;

    private final AddressMapper addressMapper = AddressMapper.INSTANCE;

    @Test
    void addressToAddressDTO() {
        Address address = Address.builder().id(ID).country(COUNTRY).city(CITY).street(STREET).number(NUMBER).build();
        AddressDTO addressDTO = addressMapper.addressToAddressDTO(address);

        assertEquals(COUNTRY, addressDTO.getCountry());
        assertEquals(CITY, addressDTO.getCity());
        assertEquals(STREET, addressDTO.getStreet());
        assertEquals(NUMBER, addressDTO.getNumber());
    }

    @Test
    void addressDTOtoAddress() {
        AddressDTO addressDTO = AddressDTO.builder().country(COUNTRY).city(CITY).street(STREET).number(NUMBER).build();
        Address address = addressMapper.addressDTOtoAddress(addressDTO);

        assertEquals(COUNTRY, address.getCountry());
        assertEquals(CITY, address.getCity());
        assertEquals(STREET, address.getStreet());
        assertEquals(NUMBER, address.getNumber());
    }
}