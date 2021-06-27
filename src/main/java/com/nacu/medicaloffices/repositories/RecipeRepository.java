package com.nacu.medicaloffices.repositories;

import com.nacu.medicaloffices.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findAllByPatient_Id(Long id);
}
