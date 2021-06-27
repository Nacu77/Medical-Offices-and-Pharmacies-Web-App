package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.MedicineStockDTO;
import com.nacu.medicaloffices.domain.MedicineStock;
import com.nacu.medicaloffices.repositories.MedicineRepository;
import com.nacu.medicaloffices.repositories.PharmacyRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        uses = {MedicineMapper.class},
        componentModel = "spring"
)
public abstract class MedicineStockMapper {

    @Autowired
    protected PharmacyRepository pharmacyRepository;

    @Autowired
    protected MedicineRepository medicineRepository;

    @Mapping(target = "pharmacyId", source = "pharmacy.id")
    public abstract MedicineStockDTO medicineStockToMedicineStockDTO(MedicineStock medicineStock);

    @Mapping(target = "medicine", expression = "java(medicineRepository.findByName(medicineStockDTO.getMedicine().getName()))")
    @Mapping(target = "pharmacy", expression = "java(pharmacyRepository.findById(medicineStockDTO.getPharmacyId()).get())")
    public abstract MedicineStock medicineStockDTOtoMedicineStock(MedicineStockDTO medicineStockDTO);
}
