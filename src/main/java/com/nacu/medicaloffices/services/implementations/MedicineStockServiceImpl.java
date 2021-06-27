package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.MedicineStockMapper;
import com.nacu.medicaloffices.api.model.MedicineStockDTO;
import com.nacu.medicaloffices.domain.MedicineStock;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.MedicineStockRepository;
import com.nacu.medicaloffices.services.MedicineStockService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineStockServiceImpl implements MedicineStockService {

    private final MedicineStockRepository repository;
    private final MedicineStockMapper mapper;

    public MedicineStockServiceImpl(MedicineStockRepository repository, MedicineStockMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MedicineStockDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::medicineStockToMedicineStockDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicineStockDTO findById(Long id) {
        return repository
                .findById(id)
                .map(mapper::medicineStockToMedicineStockDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public MedicineStockDTO create(MedicineStockDTO medicineStockDTO) {
        MedicineStock medicineStock = mapper.medicineStockDTOtoMedicineStock(medicineStockDTO);
        MedicineStock savedMedicineStock = repository.save(medicineStock);
        return mapper.medicineStockToMedicineStockDTO(savedMedicineStock);
    }

    @Override
    public MedicineStockDTO saveById(Long id, MedicineStockDTO medicineStockDTO) {
        MedicineStock medicineStock = mapper.medicineStockDTOtoMedicineStock(medicineStockDTO);
        medicineStock.setId(id);
        MedicineStock savedMedicineStock = repository.save(medicineStock);
        return mapper.medicineStockToMedicineStockDTO(savedMedicineStock);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
