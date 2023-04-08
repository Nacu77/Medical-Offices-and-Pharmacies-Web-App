package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.AppointmentMapper;
import com.nacu.medicaloffices.api.model.AppointmentDTO;
import com.nacu.medicaloffices.domain.Appointment;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.AppointmentRepository;
import com.nacu.medicaloffices.services.AppointmentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final AppointmentMapper mapper;

    public AppointmentServiceImpl(AppointmentRepository repository, AppointmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<AppointmentDTO> findAll() {
        log.info("Finding all appointments");
        return repository
                .findAll()
                .stream()
                .map(mapper::appointmentToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO findById(Long id) {
        log.info("Finding appointment with id: " + id);
        return repository
                .findById(id)
                .map(mapper::appointmentToAppointmentDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
        log.info("Creating new appointment");
        Appointment appointment = mapper.appointmentDTOtoAppointment(appointmentDTO);
        Appointment savedAppointment = repository.save(appointment);
        return mapper.appointmentToAppointmentDTO(savedAppointment);
    }

    @Override
    public AppointmentDTO saveById(Long id, AppointmentDTO appointmentDTO) {
        log.info("Saving appointment with id: " + id);
        Appointment appointment = mapper.appointmentDTOtoAppointment(appointmentDTO);
        appointment.setId(id);
        Appointment savedAppointment = repository.save(appointment);
        return mapper.appointmentToAppointmentDTO(savedAppointment);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting appointment with id: " + id);
        repository.deleteById(id);
    }

    @Override
    public List<AppointmentDTO> findAllByPatientId(Long id) {
        log.info("Finding appointments with patient id: " + id);
        return repository
                .findAllByPatient_Id(id)
                .stream()
                .map(mapper::appointmentToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findAllByMedicalOfficeId(Long id) {
        log.info("Finding appointments with medical office id: " + id);
        return repository
                .findAllByMedicalOffice_Id(id)
                .stream()
                .map(mapper::appointmentToAppointmentDTO)
                .collect(Collectors.toList());
    }
}
