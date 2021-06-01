package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.MedicineStockDTO;
import com.nacu.medicaloffices.domain.MedicineStock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {MedicineMapper.class},
        componentModel = "spring"
)
public interface MedicineStockMapper {
    MedicineStockMapper INSTANCE = Mappers.getMapper(MedicineStockMapper.class);
    MedicineStockDTO medicineStockToMedicineStockDTO(MedicineStock medicineStock);
    MedicineStock medicineStockDTOtoMedicineStock(MedicineStockDTO medicineStockDTO);
}
