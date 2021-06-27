package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.MedicineDTO;
import com.nacu.medicaloffices.domain.Medicine;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicineMapper {
    MedicineDTO medicineToMedicineDTO(Medicine medicine);
    Medicine medicineDTOtoMedicine(MedicineDTO medicineDTO);
}
