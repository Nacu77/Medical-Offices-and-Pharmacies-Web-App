package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.AddressDTO;
import com.nacu.medicaloffices.domain.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    AddressDTO addressToAddressDTO(Address address);
    Address addressDTOtoAddress(AddressDTO addressDTO);
}
