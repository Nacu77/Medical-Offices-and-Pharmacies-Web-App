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

    private final MedicineRepository medicineRepository;
    private final MedicineMapper medicineMapper;

    public MedicineServiceImpl(MedicineRepository medicineRepository, MedicineMapper medicineMapper) {
        this.medicineRepository = medicineRepository;
        this.medicineMapper = medicineMapper;
    }

    @Override
    public List<MedicineDTO> findAll() {
        return medicineRepository
                .findAll()
                .stream()
                .map(medicineMapper::medicineToMedicineDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicineDTO findById(Long id) {
        return medicineRepository
                .findById(id)
                .map(medicineMapper::medicineToMedicineDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public MedicineDTO create(MedicineDTO medicineDTO) {
        Medicine medicine = medicineMapper.medicineDTOtoMedicine(medicineDTO);
        Medicine savedMedicine = medicineRepository.save(medicine);
        return medicineMapper.medicineToMedicineDTO(savedMedicine);
    }

    @Override
    public MedicineDTO saveById(Long id, MedicineDTO medicineDTO) {
        Medicine medicine = medicineMapper.medicineDTOtoMedicine(medicineDTO);
        medicine.setId(id);
        Medicine savedMedicine = medicineRepository.save(medicine);
        return medicineMapper.medicineToMedicineDTO(savedMedicine);
    }

    @Override
    public void deleteById(Long id) {
        medicineRepository.deleteById(id);
    }
}
