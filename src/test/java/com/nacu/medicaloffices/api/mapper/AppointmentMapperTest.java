package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.AppointmentDTO;
import com.nacu.medicaloffices.domain.Appointment;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppointmentMapperTest {

    private final String DESCRIPTION = "I feel very bad";
    private final LocalDateTime DATE = LocalDateTime.now();

    private final AppointmentMapper appointmentMapper = AppointmentMapper.INSTANCE;

    @Test
    void appointmentToAppointmentDTO() {
        Appointment appointment = Appointment.builder().description(DESCRIPTION).date(DATE).build();
        AppointmentDTO appointmentDTO = appointmentMapper.appointmentToAppointmentDTO(appointment);

        assertEquals(DESCRIPTION, appointmentDTO.getDescription());
        assertEquals(DATE, appointmentDTO.getDate());
    }

    @Test
    void appointmentDTOtoAppointment() {
        AppointmentDTO appointmentDTO = AppointmentDTO.builder().description(DESCRIPTION).date(DATE).build();
        Appointment appointment = appointmentMapper.appointmentDTOtoAppointment(appointmentDTO);

        assertEquals(DESCRIPTION, appointment.getDescription());
        assertEquals(DATE, appointment.getDate());
    }
}