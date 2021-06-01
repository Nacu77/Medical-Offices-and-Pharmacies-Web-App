package com.nacu.medicaloffices.controllers;

import com.nacu.medicaloffices.api.model.MedicalOfficeDTO;
import com.nacu.medicaloffices.services.MedicalOfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MedicalOfficeController.BASE_URL)
public class MedicalOfficeController {

    public static final String BASE_URL = "/api/medical-offices";

    private final MedicalOfficeService service;

    public MedicalOfficeController(MedicalOfficeService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MedicalOfficeDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicalOfficeDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicalOfficeDTO create(@RequestBody MedicalOfficeDTO medicalOfficeDTO) {
        return service.create(medicalOfficeDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicalOfficeDTO update(@PathVariable Long id, @RequestBody MedicalOfficeDTO medicalOfficeDTO) {
        return service.saveById(id, medicalOfficeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
