package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.RecipeDTO;
import com.nacu.medicaloffices.domain.Recipe;
import com.nacu.medicaloffices.repositories.PatientRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        uses = {MedicineMapper.class},
        componentModel = "spring"
)
public abstract class RecipeMapper {

    @Autowired
    protected PatientRepository patientRepository;

    @Mapping(target = "patientId", source = "patient.id")
    public abstract RecipeDTO recipeToRecipeDTO(Recipe recipe);

    @Mapping(target = "patient", expression = "java(patientRepository.findById(recipeDTO.getPatientId()).get())")
    public abstract Recipe recipeDTOtoRecipe(RecipeDTO recipeDTO);
}
