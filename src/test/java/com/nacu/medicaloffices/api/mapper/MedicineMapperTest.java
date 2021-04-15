package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.MedicineDTO;
import com.nacu.medicaloffices.domain.Medicine;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedicineMapperTest {

    private final String NAME = "Aspirin";

    private final MedicineMapper medicineMapper = MedicineMapper.INSTANCE;

    @Test
    void medicineToMedicineDTO() {
        Medicine medicine = Medicine.builder().name(NAME).build();
        MedicineDTO medicineDTO = medicineMapper.medicineToMedicineDTO(medicine);

        assertEquals(NAME, medicineDTO.getName());
    }

    @Test
    void medicineDTOtoMedicine() {
        MedicineDTO medicineDTO = MedicineDTO.builder().name(NAME).build();
        Medicine medicine = medicineMapper.medicineDTOtoMedicine(medicineDTO);

        assertEquals(NAME, medicine.getName());
    }
}