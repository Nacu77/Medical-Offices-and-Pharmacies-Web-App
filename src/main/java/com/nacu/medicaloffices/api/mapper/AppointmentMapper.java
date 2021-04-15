package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.AppointmentDTO;
import com.nacu.medicaloffices.domain.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);
    AppointmentDTO appointmentToAppointmentDTO(Appointment appointment);
    Appointment appointmentDTOtoAppointment(AppointmentDTO appointmentDTO);
}
