package com.nacu.medicaloffices.controllers;

import com.nacu.medicaloffices.api.model.MedicineDTO;
import com.nacu.medicaloffices.services.MedicineService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MedicineController.BASE_URL)
public class MedicineController {

    public static final String BASE_URL = "/api/medicines";

    private final MedicineService service;

    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MedicineDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicineDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicineDTO create(@RequestBody MedicineDTO medicineDTO) {
        return service.create(medicineDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicineDTO update(@PathVariable Long id, @RequestBody MedicineDTO medicineDTO) {
        return service.saveById(id, medicineDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
