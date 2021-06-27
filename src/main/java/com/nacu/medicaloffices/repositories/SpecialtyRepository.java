package com.nacu.medicaloffices.repositories;

import com.nacu.medicaloffices.domain.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
    Specialty findByName(String name);
}
