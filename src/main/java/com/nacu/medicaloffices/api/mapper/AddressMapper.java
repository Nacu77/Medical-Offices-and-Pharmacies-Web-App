package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.AddressDTO;
import com.nacu.medicaloffices.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTO addressToAddressDTO(Address address);
    Address addressDTOtoAddress(AddressDTO addressDTO);
}
