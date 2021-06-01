package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.DoctorMapper;
import com.nacu.medicaloffices.api.model.DoctorDTO;
import com.nacu.medicaloffices.domain.Doctor;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.DoctorRepository;
import com.nacu.medicaloffices.services.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;
    private final DoctorMapper mapper;

    public DoctorServiceImpl(DoctorRepository repository, DoctorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<DoctorDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::doctorToDoctorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DoctorDTO findById(Long id) {
        return repository
                .findById(id)
                .map(mapper::doctorToDoctorDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public DoctorDTO create(DoctorDTO doctorDTO) {
        Doctor doctor = mapper.doctorDTOtoDoctor(doctorDTO);
        Doctor savedDoctor = repository.save(doctor);
        return mapper.doctorToDoctorDTO(savedDoctor);
    }

    @Override
    public DoctorDTO saveById(Long id, DoctorDTO doctorDTO) {
        Doctor doctor = mapper.doctorDTOtoDoctor(doctorDTO);
        doctor.setId(id);
        Doctor savedDoctor = repository.save(doctor);
        return mapper.doctorToDoctorDTO(savedDoctor);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
