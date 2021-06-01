package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.PharmacyDTO;
import com.nacu.medicaloffices.domain.Pharmacy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {ContactDataMapper.class, AddressMapper.class, MedicineStockMapper.class},
        componentModel = "spring"
)
public interface PharmacyMapper {
    PharmacyMapper INSTANCE = Mappers.getMapper(PharmacyMapper.class);

    @Mapping(source="pharmacyOwner.id", target="ownerId")
    PharmacyDTO pharmacyToPharmacyDTO(Pharmacy pharmacy);

    Pharmacy pharmacyDTOtoPharmacy(PharmacyDTO pharmacyDTO);
}
