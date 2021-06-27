package com.nacu.medicaloffices.repositories;

import com.nacu.medicaloffices.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findByLastName(String name);
}
