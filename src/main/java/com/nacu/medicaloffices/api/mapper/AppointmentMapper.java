package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.AppointmentDTO;
import com.nacu.medicaloffices.domain.Appointment;
import com.nacu.medicaloffices.repositories.MedicalOfficeRepository;
import com.nacu.medicaloffices.repositories.PatientRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AppointmentMapper {

    @Autowired
    protected MedicalOfficeRepository medicalOfficeRepository;

    @Autowired
    protected PatientRepository patientRepository;

    @Mapping(source = "patient.id", target = "patientId")
    @Mapping(target = "patientName", expression = "java(appointment.getPatient().getLastName() + ' ' + appointment.getPatient().getFirstName())")
    @Mapping(source = "medicalOffice.id", target = "medicalOfficeId")
    @Mapping(source = "medicalOffice.name", target = "medicalOfficeName")
    public abstract AppointmentDTO appointmentToAppointmentDTO(Appointment appointment);

    @Mapping(target = "patient", expression = "java(patientRepository.findById(appointmentDTO.getPatientId()).get())")
    @Mapping(target = "medicalOffice", expression = "java(medicalOfficeRepository.findById(appointmentDTO.getMedicalOfficeId()).get())")
    public abstract Appointment appointmentDTOtoAppointment(AppointmentDTO appointmentDTO);
}
