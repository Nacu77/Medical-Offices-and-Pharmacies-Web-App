package com.nacu.medicaloffices.repositories;

import com.nacu.medicaloffices.domain.PharmacyOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyOwnerRepository extends JpaRepository<PharmacyOwner, Long> {
    PharmacyOwner findByLastName(String name);
}
