package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.ContactDataDTO;
import com.nacu.medicaloffices.domain.ContactData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactDataMapperTest {

    private final Long ID = 1L;
    private final String PHONE_NUMBER = "0761111111";
    private final String EMAIL = "florin@email.com";

    private final ContactDataMapper contactDataMapper = ContactDataMapper.INSTANCE;

    @Test
    void contactDataToContactDataDTO() {
        ContactData contactData = ContactData.builder().id(ID).phoneNumber(PHONE_NUMBER).email(EMAIL).build();
        ContactDataDTO contactDataDTO = contactDataMapper.contactDataToContactDataDTO(contactData);

        assertEquals(PHONE_NUMBER, contactDataDTO.getPhoneNumber());
        assertEquals(EMAIL, contactDataDTO.getEmail());
    }

    @Test
    void contactDataDTOtoContactData() {
        ContactDataDTO contactDataDTO = ContactDataDTO.builder().phoneNumber(PHONE_NUMBER).email(EMAIL).build();
        ContactData contactData = contactDataMapper.contactDataDTOtoContactData(contactDataDTO);

        assertEquals(PHONE_NUMBER, contactData.getPhoneNumber());
        assertEquals(EMAIL, contactData.getEmail());
    }
}