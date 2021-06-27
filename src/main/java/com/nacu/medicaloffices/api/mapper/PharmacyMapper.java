package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.PharmacyDTO;
import com.nacu.medicaloffices.domain.Pharmacy;
import com.nacu.medicaloffices.repositories.PharmacyOwnerRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        uses = {ContactDataMapper.class, AddressMapper.class, MedicineStockMapper.class},
        componentModel = "spring"
)
public abstract class PharmacyMapper {

    @Autowired
    protected PharmacyOwnerRepository pharmacyOwnerRepository;

    @Mapping(source="pharmacyOwner.id", target="ownerId")
    public abstract PharmacyDTO pharmacyToPharmacyDTO(Pharmacy pharmacy);

    @Mapping(target = "pharmacyOwner", expression = "java(pharmacyOwnerRepository.findById(pharmacyDTO.getOwnerId()).get())")
    public abstract Pharmacy pharmacyDTOtoPharmacy(PharmacyDTO pharmacyDTO);
}
