package com.nacu.medicaloffices.repositories;

import com.nacu.medicaloffices.domain.MedicineStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineStockRepository extends JpaRepository<MedicineStock, Long> {
}
