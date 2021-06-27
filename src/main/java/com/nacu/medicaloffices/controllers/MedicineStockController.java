package com.nacu.medicaloffices.controllers;

import com.nacu.medicaloffices.api.model.MedicineStockDTO;
import com.nacu.medicaloffices.services.MedicineStockService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MedicineStockController.BASE_URL)
public class MedicineStockController {
    
    public static final String BASE_URL = "/api/medicine-stock";

    private final MedicineStockService service;

    public MedicineStockController(MedicineStockService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MedicineStockDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicineStockDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicineStockDTO create(@RequestBody MedicineStockDTO medicineStockDTO) {
        return service.create(medicineStockDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicineStockDTO update(@PathVariable Long id, @RequestBody MedicineStockDTO medicineStockDTO) {
        return service.saveById(id, medicineStockDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
