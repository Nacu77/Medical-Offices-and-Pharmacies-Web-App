package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.PharmacyDTO;
import com.nacu.medicaloffices.domain.Pharmacy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ContactDataMapper.class, AddressMapper.class, MedicineStockMapper.class})
public interface PharmacyMapper {
    PharmacyMapper INSTANCE = Mappers.getMapper(PharmacyMapper.class);
    PharmacyDTO pharmacyToPharmacyDTO(Pharmacy pharmacy);
    Pharmacy pharmacyDTOtoPharmacy(PharmacyDTO pharmacyDTO);
}
