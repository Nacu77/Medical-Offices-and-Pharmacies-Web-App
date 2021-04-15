package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.MedicineDTO;
import com.nacu.medicaloffices.domain.Medicine;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MedicineMapper {
    MedicineMapper INSTANCE = Mappers.getMapper(MedicineMapper.class);
    MedicineDTO medicineToMedicineDTO(Medicine medicine);
    Medicine medicineDTOtoMedicine(MedicineDTO medicineDTO);
}
