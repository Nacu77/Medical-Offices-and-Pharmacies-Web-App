package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.MedicineMapper;
import com.nacu.medicaloffices.api.model.MedicineDTO;
import com.nacu.medicaloffices.domain.Medicine;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.MedicineRepository;
import com.nacu.medicaloffices.services.MedicineService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository repository;
    private final MedicineMapper mapper;

    public MedicineServiceImpl(MedicineRepository repository, MedicineMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MedicineDTO> findAll() {
        log.info("Finding all medicines");
        return repository
                .findAll()
                .stream()
                .map(mapper::medicineToMedicineDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicineDTO findById(Long id) {
        log.info("Finding medicine with id: " + id);
        return repository
                .findById(id)
                .map(mapper::medicineToMedicineDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public MedicineDTO create(MedicineDTO medicineDTO) {
        log.info("Creating new medicine");
        Medicine medicine = mapper.medicineDTOtoMedicine(medicineDTO);
        Medicine savedMedicine = repository.save(medicine);
        return mapper.medicineToMedicineDTO(savedMedicine);
    }

    @Override
    public MedicineDTO saveById(Long id, MedicineDTO medicineDTO) {
        log.info("Saving medicine with id: " + id);
        Medicine medicine = mapper.medicineDTOtoMedicine(medicineDTO);
        medicine.setId(id);
        Medicine savedMedicine = repository.save(medicine);
        return mapper.medicineToMedicineDTO(savedMedicine);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting medicine with id: " + id);
        repository.deleteById(id);
    }
}
