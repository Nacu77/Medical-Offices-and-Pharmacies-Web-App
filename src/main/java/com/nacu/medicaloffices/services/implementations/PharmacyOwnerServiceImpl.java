package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.PharmacyOwnerMapper;
import com.nacu.medicaloffices.api.model.PharmacyOwnerDTO;
import com.nacu.medicaloffices.domain.PharmacyOwner;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.PharmacyOwnerRepository;
import com.nacu.medicaloffices.services.PharmacyOwnerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class PharmacyOwnerServiceImpl implements PharmacyOwnerService {

    private final PharmacyOwnerRepository repository;
    private final PharmacyOwnerMapper mapper;

    public PharmacyOwnerServiceImpl(PharmacyOwnerRepository repository, PharmacyOwnerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PharmacyOwnerDTO> findAll() {
        log.info("Finding all pharmacy owners");
        return repository
                .findAll()
                .stream()
                .map(mapper::pharmacyOwnerToPharmacyOwnerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PharmacyOwnerDTO findById(Long id) {
        log.info("Finding pharmacy owner with id: " + id);
        return repository
                .findById(id)
                .map(mapper::pharmacyOwnerToPharmacyOwnerDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public PharmacyOwnerDTO create(PharmacyOwnerDTO pharmacyOwnerDTO) {
        log.info("Creating new pharmacy owner");
        PharmacyOwner pharmacyOwner = mapper.pharmacyOwnerDTOtoPharmacyOwner(pharmacyOwnerDTO);
        PharmacyOwner savedPharmacyOwner = repository.save(pharmacyOwner);
        return mapper.pharmacyOwnerToPharmacyOwnerDTO(savedPharmacyOwner);
    }

    @Override
    public PharmacyOwnerDTO saveById(Long id, PharmacyOwnerDTO pharmacyOwnerDTO) {
        log.info("Saving pharmacy owner with id: " + id);
        PharmacyOwner pharmacyOwner = mapper.pharmacyOwnerDTOtoPharmacyOwner(pharmacyOwnerDTO);
        pharmacyOwner.setId(id);
        PharmacyOwner savedPharmacyOwner = repository.save(pharmacyOwner);
        return mapper.pharmacyOwnerToPharmacyOwnerDTO(savedPharmacyOwner);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting pharmacy owner with id: " + id);
        repository.deleteById(id);
    }
}
