package com.nacu.medicaloffices.controllers;

import com.nacu.medicaloffices.api.model.PharmacyDTO;
import com.nacu.medicaloffices.services.PharmacyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PharmacyController.BASE_URL)
public class PharmacyController {

    public static final String BASE_URL = "/api/pharmacies";

    private final PharmacyService service;

    public PharmacyController(PharmacyService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PharmacyDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PharmacyDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PharmacyDTO create(@RequestBody PharmacyDTO pharmacyDTO) {
        return service.create(pharmacyDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PharmacyDTO update(@PathVariable Long id, @RequestBody PharmacyDTO pharmacyDTO) {
        return service.saveById(id, pharmacyDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
