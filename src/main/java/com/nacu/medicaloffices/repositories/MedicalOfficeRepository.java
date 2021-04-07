package com.nacu.medicaloffices.repositories;

import com.nacu.medicaloffices.domain.MedicalOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalOfficeRepository extends JpaRepository<MedicalOffice, Long> {
}
