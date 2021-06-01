package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.MedicineMapper;
import com.nacu.medicaloffices.api.model.MedicineDTO;
import com.nacu.medicaloffices.domain.Medicine;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.MedicineRepository;
import com.nacu.medicaloffices.services.MedicineService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository repository;
    private final MedicineMapper mapper;

    public MedicineServiceImpl(MedicineRepository repository, MedicineMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MedicineDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::medicineToMedicineDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicineDTO findById(Long id) {
        return repository
                .findById(id)
                .map(mapper::medicineToMedicineDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public MedicineDTO create(MedicineDTO medicineDTO) {
        Medicine medicine = mapper.medicineDTOtoMedicine(medicineDTO);
        Medicine savedMedicine = repository.save(medicine);
        return mapper.medicineToMedicineDTO(savedMedicine);
    }

    @Override
    public MedicineDTO saveById(Long id, MedicineDTO medicineDTO) {
        Medicine medicine = mapper.medicineDTOtoMedicine(medicineDTO);
        medicine.setId(id);
        Medicine savedMedicine = repository.save(medicine);
        return mapper.medicineToMedicineDTO(savedMedicine);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
