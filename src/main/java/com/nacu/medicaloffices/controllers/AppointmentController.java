package com.nacu.medicaloffices.controllers;

import com.nacu.medicaloffices.api.model.AppointmentDTO;
import com.nacu.medicaloffices.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(AppointmentController.BASE_URL)
public class AppointmentController {

    public static final String BASE_URL = "/api/appointments";

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentDTO create(@RequestBody AppointmentDTO appointmentDTO) {
        return service.create(appointmentDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentDTO update(@PathVariable Long id, @RequestBody AppointmentDTO appointmentDTO) {
        return service.saveById(id, appointmentDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/patient/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentDTO> getAllByPatientId(@PathVariable Long id) {
        return service.findAllByPatientId(id);
    }

    @GetMapping("/medical-office/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentDTO> getAllByMedicalOfficeId(@PathVariable Long id) {
        return service.findAllByMedicalOfficeId(id);
    }
}
