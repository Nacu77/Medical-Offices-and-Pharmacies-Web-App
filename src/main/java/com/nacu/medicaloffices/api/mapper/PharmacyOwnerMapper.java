package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.PharmacyOwnerDTO;
import com.nacu.medicaloffices.domain.PharmacyOwner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ContactDataMapper.class, PharmacyMapper.class})
public interface PharmacyOwnerMapper {
    PharmacyOwnerMapper INSTANCE = Mappers.getMapper(PharmacyOwnerMapper.class);
    PharmacyOwnerDTO pharmacyOwnerToPharmacyOwnerDTO(PharmacyOwner pharmacyOwner);
    PharmacyOwner pharmacyOwnerDTOtoPharmacyOwner(PharmacyOwnerDTO pharmacyOwnerDTO);
}
