package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.ContactDataDTO;
import com.nacu.medicaloffices.domain.ContactData;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContactDataMapper {
    ContactDataMapper INSTANCE = Mappers.getMapper(ContactDataMapper.class);
    ContactDataDTO contactDataToContactDataDTO(ContactData contactData);
    ContactData contactDataDTOtoContactData(ContactDataDTO contactDataDTO);
}
