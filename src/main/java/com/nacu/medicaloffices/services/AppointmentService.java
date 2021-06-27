package com.nacu.medicaloffices.services;

import com.nacu.medicaloffices.api.model.AppointmentDTO;

import java.util.List;

public interface AppointmentService extends CrudService<AppointmentDTO, Long> {
    List<AppointmentDTO> findAllByPatientId(Long id);
    List<AppointmentDTO> findAllByMedicalOfficeId(Long id);
}
