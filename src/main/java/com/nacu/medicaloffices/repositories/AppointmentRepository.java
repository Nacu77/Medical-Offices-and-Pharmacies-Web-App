package com.nacu.medicaloffices.repositories;

import com.nacu.medicaloffices.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findAllByPatient_Id(Long id);
    List<Appointment> findAllByMedicalOffice_Id(Long id);
}
