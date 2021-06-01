package com.nacu.medicaloffices.controllers;

import com.nacu.medicaloffices.api.model.DoctorDTO;
import com.nacu.medicaloffices.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DoctorController.BASE_URL)
public class DoctorController {

    public static final String BASE_URL = "/api/doctors";

    private final DoctorService service;

    public DoctorController(DoctorService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DoctorDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoctorDTO create(@RequestBody DoctorDTO doctorDTO) {
        return service.create(doctorDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DoctorDTO update(@PathVariable Long id, @RequestBody DoctorDTO doctorDTO) {
        return service.saveById(id, doctorDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
