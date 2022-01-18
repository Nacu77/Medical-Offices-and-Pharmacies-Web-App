package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.AppointmentMapper;
import com.nacu.medicaloffices.api.model.AppointmentDTO;
import com.nacu.medicaloffices.domain.Appointment;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TestAppointmentServiceImpl {

    @Mock
    AppointmentRepository repository;

    @Mock
    AppointmentMapper mapper;

    @InjectMocks
    AppointmentServiceImpl service;

    @Test
    void findAll() {
        Appointment repoReturn1 = Appointment.builder().id(1L).build();
        Appointment repoReturn2 = Appointment.builder().id(2L).build();
        List<Appointment> repoReturnList = List.of(repoReturn1, repoReturn2);

        AppointmentDTO mappedDto1 = AppointmentDTO.builder().id(1L).build();
        AppointmentDTO mappedDto2 = AppointmentDTO.builder().id(2L).build();
        List<AppointmentDTO> expectedDtoList = List.of(mappedDto1, mappedDto2);

        when(repository.findAll()).thenReturn(repoReturnList);
        when(mapper.appointmentToAppointmentDTO(repoReturn1)).thenReturn(mappedDto1);
        when(mapper.appointmentToAppointmentDTO(repoReturn2)).thenReturn(mappedDto2);
        List<AppointmentDTO> returnDtoList = service.findAll();

        assertNotNull(returnDtoList);
        assertEquals(2, returnDtoList.size());
        assertArrayEquals(expectedDtoList.toArray(), returnDtoList.toArray());
    }

    @Test
    void findById() {
        Appointment repoReturn = Appointment.builder().id(1L).build();
        AppointmentDTO expectedDto = AppointmentDTO.builder().id(1L).build();

        when(repository.findById(1L)).thenReturn(Optional.of(repoReturn));
        when(mapper.appointmentToAppointmentDTO(repoReturn)).thenReturn(expectedDto);
        AppointmentDTO returnDto = service.findById(1L);

        assertNotNull(returnDto);
        assertEquals(expectedDto, returnDto);
    }

    @Test
    void findByIdNotFound() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> service.findById(1L));

        assertNotNull(exception);
        verify(mapper, times(0)).appointmentToAppointmentDTO(any());
    }

    @Test
    void create() {
        AppointmentDTO dtoToSave = AppointmentDTO.builder().description("desc").build();
        Appointment toSave = Appointment.builder().description("desc").build();
        Appointment saved = Appointment.builder().id(1L).description("desc").build();
        AppointmentDTO dtoSaved = AppointmentDTO.builder().id(1L).description("desc").build();

        when(mapper.appointmentDTOtoAppointment(dtoToSave)).thenReturn(toSave);
        when(repository.save(toSave)).thenReturn(saved);
        when(mapper.appointmentToAppointmentDTO(saved)).thenReturn(dtoSaved);

        AppointmentDTO returnDto = service.create(dtoToSave);

        assertNotNull(returnDto);
        assertEquals(dtoSaved, returnDto);
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}
