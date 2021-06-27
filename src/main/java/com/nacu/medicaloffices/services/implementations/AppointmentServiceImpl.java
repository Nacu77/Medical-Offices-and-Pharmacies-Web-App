package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.AppointmentMapper;
import com.nacu.medicaloffices.api.model.AppointmentDTO;
import com.nacu.medicaloffices.domain.Appointment;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.AppointmentRepository;
import com.nacu.medicaloffices.services.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;
    private final AppointmentMapper mapper;

    public AppointmentServiceImpl(AppointmentRepository repository, AppointmentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<AppointmentDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::appointmentToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AppointmentDTO findById(Long id) {
        return repository
                .findById(id)
                .map(mapper::appointmentToAppointmentDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.appointmentDTOtoAppointment(appointmentDTO);
        Appointment savedAppointment = repository.save(appointment);
        return mapper.appointmentToAppointmentDTO(savedAppointment);
    }

    @Override
    public AppointmentDTO saveById(Long id, AppointmentDTO appointmentDTO) {
        Appointment appointment = mapper.appointmentDTOtoAppointment(appointmentDTO);
        appointment.setId(id);
        Appointment savedAppointment = repository.save(appointment);
        return mapper.appointmentToAppointmentDTO(savedAppointment);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<AppointmentDTO> findAllByPatientId(Long id) {
        return repository
                .findAllByPatient_Id(id)
                .stream()
                .map(mapper::appointmentToAppointmentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentDTO> findAllByMedicalOfficeId(Long id) {
        return repository
                .findAllByMedicalOffice_Id(id)
                .stream()
                .map(mapper::appointmentToAppointmentDTO)
                .collect(Collectors.toList());
    }
}
