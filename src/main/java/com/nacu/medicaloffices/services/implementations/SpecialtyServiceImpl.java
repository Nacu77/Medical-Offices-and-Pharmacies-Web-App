package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.SpecialtyMapper;
import com.nacu.medicaloffices.api.model.SpecialtyDTO;
import com.nacu.medicaloffices.domain.Specialty;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.SpecialtyRepository;
import com.nacu.medicaloffices.services.SpecialtyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
    
    private final SpecialtyRepository repository;
    private final SpecialtyMapper mapper;

    public SpecialtyServiceImpl(SpecialtyRepository repository, SpecialtyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<SpecialtyDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::specialtyToSpecialtyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SpecialtyDTO findById(Long id) {
        return repository
                .findById(id)
                .map(mapper::specialtyToSpecialtyDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public SpecialtyDTO create(SpecialtyDTO specialtyDTO) {
        Specialty specialty = mapper.specialtyDTOtoSpecialty(specialtyDTO);
        Specialty savedSpecialty = repository.save(specialty);
        return mapper.specialtyToSpecialtyDTO(savedSpecialty);
    }

    @Override
    public SpecialtyDTO saveById(Long id, SpecialtyDTO specialtyDTO) {
        Specialty specialty = mapper.specialtyDTOtoSpecialty(specialtyDTO);
        specialty.setId(id);
        Specialty savedSpecialty = repository.save(specialty);
        return mapper.specialtyToSpecialtyDTO(savedSpecialty);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
