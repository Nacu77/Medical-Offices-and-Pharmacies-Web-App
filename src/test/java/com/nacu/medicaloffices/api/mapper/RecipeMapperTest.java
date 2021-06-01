package com.nacu.medicaloffices.api.mapper;

import com.nacu.medicaloffices.api.model.MedicineDTO;
import com.nacu.medicaloffices.domain.Medicine;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class RecipeMapperTest {

    private final String DESCRIPTION = "Take 3 of each per day";
    private final Set<Medicine> MEDICINES_SET = Set.of(
            Medicine.builder().build(),
            Medicine.builder().build()
    );
    private final List<MedicineDTO> MEDICINES_LIST = List.of(
            MedicineDTO.builder().build(),
            MedicineDTO.builder().build()
    );

    private final RecipeMapper recipeMapper = RecipeMapper.INSTANCE;

    @Test
    void recipeToRecipeDTO() {
//        Recipe recipe = Recipe.builder().description(DESCRIPTION).medicines(MEDICINES_SET).build();
//        RecipeDTO recipeDTO = recipeMapper.recipeToRecipeDTO(recipe);
//
//        assertEquals(DESCRIPTION, recipeDTO.getDescription());
//        assertEquals(MEDICINES_SET.size(), recipeDTO.getMedicines().size());
    }

    @Test
    void recipeDTOtoRecipe() {
//        RecipeDTO recipeDTO = RecipeDTO.builder().description(DESCRIPTION).medicines(MEDICINES_LIST).build();
//        Recipe recipe = recipeMapper.recipeDTOtoRecipe(recipeDTO);
//
//        assertEquals(DESCRIPTION, recipe.getDescription());
//        assertEquals(MEDICINES_LIST.size(), recipe.getMedicines().size());
    }
}