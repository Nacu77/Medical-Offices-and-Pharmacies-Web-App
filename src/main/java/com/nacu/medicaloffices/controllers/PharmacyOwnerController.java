package com.nacu.medicaloffices.controllers;

import com.nacu.medicaloffices.api.model.PharmacyOwnerDTO;
import com.nacu.medicaloffices.services.PharmacyOwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PharmacyOwnerController.BASE_URL)
public class PharmacyOwnerController {

    public static final String BASE_URL = "/api/pharmacy-owners";

    private final PharmacyOwnerService service;

    public PharmacyOwnerController(PharmacyOwnerService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PharmacyOwnerDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PharmacyOwnerDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PharmacyOwnerDTO create(@RequestBody PharmacyOwnerDTO pharmacyOwnerDTO) {
        return service.create(pharmacyOwnerDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PharmacyOwnerDTO update(@PathVariable Long id, @RequestBody PharmacyOwnerDTO pharmacyOwnerDTO) {
        return service.saveById(id, pharmacyOwnerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
