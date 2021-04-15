package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.MedicineDTO;
import com.nacu.medicaloffices.api.model.MedicineStockDTO;
import com.nacu.medicaloffices.domain.Medicine;
import com.nacu.medicaloffices.domain.MedicineStock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MedicineStockMapperTest {

    private final int AMOUNT = 777;
    private final double PRICE = 15.5;

    private final Medicine MEDICINE = Medicine.builder().name("Aspirin").build();
    private final MedicineDTO MEDICINE_DTO = MedicineDTO.builder().name("Aspirin").build();

    private final MedicineStockMapper medicineStockMapper = MedicineStockMapper.INSTANCE;

    @Test
    void medicineStockToMedicineStockDTO() {
        MedicineStock medicineStock = MedicineStock.builder().amount(AMOUNT).price(PRICE).medicine(MEDICINE).build();
        MedicineStockDTO medicineStockDTO = medicineStockMapper.medicineStockToMedicineStockDTO(medicineStock);

        assertEquals(AMOUNT, medicineStockDTO.getAmount());
        assertEquals(PRICE, medicineStockDTO.getPrice());
        assertEquals(MEDICINE.getName(), medicineStockDTO.getMedicine().getName());
    }

    @Test
    void medicineStockDTOtoMedicineStock() {
        MedicineStockDTO medicineStockDTO = MedicineStockDTO.builder().amount(AMOUNT).price(PRICE).medicine(MEDICINE_DTO).build();
        MedicineStock medicineStock = medicineStockMapper.medicineStockDTOtoMedicineStock(medicineStockDTO);

        assertEquals(AMOUNT, medicineStock.getAmount());
        assertEquals(PRICE, medicineStock.getPrice());
        assertEquals(MEDICINE.getName(), medicineStock.getMedicine().getName());
    }
}