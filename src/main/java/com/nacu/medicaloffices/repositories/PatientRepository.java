package com.nacu.medicaloffices.repositories;

import com.nacu.medicaloffices.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByLastName(String lastName);
}
