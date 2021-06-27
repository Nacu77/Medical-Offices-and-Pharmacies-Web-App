package com.nacu.medicaloffices.services;

import com.nacu.medicaloffices.api.model.RecipeDTO;

import java.util.List;

public interface RecipeService extends CrudService<RecipeDTO, Long> {
    List<RecipeDTO> findAllByPatientId(Long id);
}
