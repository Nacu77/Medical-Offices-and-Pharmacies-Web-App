package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.RecipeDTO;
import com.nacu.medicaloffices.domain.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(
        uses = {MedicineMapper.class},
        componentModel = "spring"
)
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);
    RecipeDTO recipeToRecipeDTO(Recipe recipe);
    Recipe recipeDTOtoRecipe(RecipeDTO recipeDTO);
}
