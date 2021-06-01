package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.MedicalOfficeMapper;
import com.nacu.medicaloffices.api.model.MedicalOfficeDTO;
import com.nacu.medicaloffices.domain.MedicalOffice;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.MedicalOfficeRepository;
import com.nacu.medicaloffices.services.MedicalOfficeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalOfficeServiceImpl implements MedicalOfficeService {

    private final MedicalOfficeRepository repository;
    private final MedicalOfficeMapper mapper;

    public MedicalOfficeServiceImpl(MedicalOfficeRepository repository, MedicalOfficeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MedicalOfficeDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::medicalOfficeToMedicalOfficeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MedicalOfficeDTO findById(Long id) {
        return repository
                .findById(id)
                .map(mapper::medicalOfficeToMedicalOfficeDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public MedicalOfficeDTO create(MedicalOfficeDTO medicalOfficeDTO) {
        MedicalOffice medicalOffice = mapper.medicalOfficeDTOtoMedicalOffice(medicalOfficeDTO);
        MedicalOffice savedMedicalOffice = repository.save(medicalOffice);
        return mapper.medicalOfficeToMedicalOfficeDTO(savedMedicalOffice);
    }

    @Override
    public MedicalOfficeDTO saveById(Long id, MedicalOfficeDTO medicalOfficeDTO) {
        MedicalOffice medicalOffice = mapper.medicalOfficeDTOtoMedicalOffice(medicalOfficeDTO);
        medicalOffice.setId(id);
        MedicalOffice savedMedicalOffice = repository.save(medicalOffice);
        return mapper.medicalOfficeToMedicalOfficeDTO(savedMedicalOffice);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
