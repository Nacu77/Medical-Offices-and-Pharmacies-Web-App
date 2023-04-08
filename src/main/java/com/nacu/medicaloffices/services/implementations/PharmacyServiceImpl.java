package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.PharmacyMapper;
import com.nacu.medicaloffices.api.model.PharmacyDTO;
import com.nacu.medicaloffices.domain.Pharmacy;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.PharmacyRepository;
import com.nacu.medicaloffices.services.PharmacyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class PharmacyServiceImpl implements PharmacyService {

    private final PharmacyRepository repository;
    private final PharmacyMapper mapper;

    public PharmacyServiceImpl(PharmacyRepository repository, PharmacyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PharmacyDTO> findAll() {
        log.info("Finding all pharmacies");
        return repository
                .findAll()
                .stream()
                .map(mapper::pharmacyToPharmacyDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PharmacyDTO findById(Long id) {
        log.info("Finding pharmacy with id: " + id);
        return repository
                .findById(id)
                .map(mapper::pharmacyToPharmacyDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public PharmacyDTO create(PharmacyDTO pharmacyDTO) {
        log.info("Creating new pharmacy");
        Pharmacy pharmacy = mapper.pharmacyDTOtoPharmacy(pharmacyDTO);
        Pharmacy savedPharmacy = repository.save(pharmacy);
        return mapper.pharmacyToPharmacyDTO(savedPharmacy);
    }

    @Override
    public PharmacyDTO saveById(Long id, PharmacyDTO pharmacyDTO) {
        log.info("Saving pharmacy with id: " + id);
        Pharmacy pharmacy = mapper.pharmacyDTOtoPharmacy(pharmacyDTO);
        pharmacy.setId(id);
        Pharmacy savedPharmacy = repository.save(pharmacy);
        return mapper.pharmacyToPharmacyDTO(savedPharmacy);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting pharmacy with id: " + id);
        repository.deleteById(id);
    }
}
