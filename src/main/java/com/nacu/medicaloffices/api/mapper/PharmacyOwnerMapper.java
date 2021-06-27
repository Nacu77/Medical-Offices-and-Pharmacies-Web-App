package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.PharmacyOwnerDTO;
import com.nacu.medicaloffices.domain.PharmacyOwner;
import org.mapstruct.Mapper;

@Mapper(
        uses = {ContactDataMapper.class, PharmacyMapper.class},
        componentModel = "spring"
)
public interface PharmacyOwnerMapper {
    PharmacyOwnerDTO pharmacyOwnerToPharmacyOwnerDTO(PharmacyOwner pharmacyOwner);
    PharmacyOwner pharmacyOwnerDTOtoPharmacyOwner(PharmacyOwnerDTO pharmacyOwnerDTO);
}
