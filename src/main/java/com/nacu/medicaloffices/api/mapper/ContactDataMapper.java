package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.ContactDataDTO;
import com.nacu.medicaloffices.domain.ContactData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactDataMapper {
    ContactDataDTO contactDataToContactDataDTO(ContactData contactData);
    ContactData contactDataDTOtoContactData(ContactDataDTO contactDataDTO);
}
