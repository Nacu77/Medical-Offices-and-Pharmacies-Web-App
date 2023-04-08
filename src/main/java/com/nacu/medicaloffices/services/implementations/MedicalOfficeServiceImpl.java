package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.MedicalOfficeMapper;
import com.nacu.medicaloffices.api.model.MedicalOfficeDTO;
import com.nacu.medicaloffices.domain.MedicalOffice;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.MedicalOfficeRepository;
import com.nacu.medicaloffices.services.MedicalOfficeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class MedicalOfficeServiceImpl implements MedicalOfficeService {

    private final MedicalOfficeRepository repository;
    private final MedicalOfficeMapper mapper;

    public MedicalOfficeServiceImpl(MedicalOfficeRepository repository, MedicalOfficeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MedicalOfficeDTO> findAll() {
        log.info("Finding all medical offices");
        return repository
                .findAll()
                .stream()
                .map(mapper::medicalOfficeToMedicalOfficeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicalOfficeDTO findById(Long id) {
        log.info("Finding medical office with id: " + id);
        return repository
                .findById(id)
                .map(mapper::medicalOfficeToMedicalOfficeDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public MedicalOfficeDTO create(MedicalOfficeDTO medicalOfficeDTO) {
        log.info("Creating new medical office");
        MedicalOffice medicalOffice = mapper.medicalOfficeDTOtoMedicalOffice(medicalOfficeDTO);
        MedicalOffice savedMedicalOffice = repository.save(medicalOffice);
        return mapper.medicalOfficeToMedicalOfficeDTO(savedMedicalOffice);
    }

    @Override
    public MedicalOfficeDTO saveById(Long id, MedicalOfficeDTO medicalOfficeDTO) {
        log.info("Saving medical office with id: " + id);
        MedicalOffice medicalOffice = mapper.medicalOfficeDTOtoMedicalOffice(medicalOfficeDTO);
        medicalOffice.setId(id);
        MedicalOffice savedMedicalOffice = repository.save(medicalOffice);
        return mapper.medicalOfficeToMedicalOfficeDTO(savedMedicalOffice);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting medical office with id: " + id);
        repository.deleteById(id);
    }
}
