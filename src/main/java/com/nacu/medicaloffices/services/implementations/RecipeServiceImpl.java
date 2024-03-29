package com.nacu.medicaloffices.services.implementations;

import com.nacu.medicaloffices.api.mapper.RecipeMapper;
import com.nacu.medicaloffices.api.model.RecipeDTO;
import com.nacu.medicaloffices.domain.Recipe;
import com.nacu.medicaloffices.exceptions.ResourceNotFoundException;
import com.nacu.medicaloffices.repositories.RecipeRepository;
import com.nacu.medicaloffices.services.RecipeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class RecipeServiceImpl implements RecipeService {
    
    private final RecipeRepository repository;
    private final RecipeMapper mapper;

    public RecipeServiceImpl(RecipeRepository repository, RecipeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<RecipeDTO> findAll() {
        log.info("Finding all recipes");
        return repository
                .findAll()
                .stream()
                .map(mapper::recipeToRecipeDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecipeDTO findById(Long id) {
        log.info("Finding recipe with id: " + id);
        return repository
                .findById(id)
                .map(mapper::recipeToRecipeDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public RecipeDTO create(RecipeDTO recipeDTO) {
        log.info("Creating new recipe");
        Recipe recipe = mapper.recipeDTOtoRecipe(recipeDTO);
        Recipe savedRecipe = repository.save(recipe);
        return mapper.recipeToRecipeDTO(savedRecipe);
    }

    @Override
    public RecipeDTO saveById(Long id, RecipeDTO recipeDTO) {
        log.info("Saving recipe with id: " + id);
        Recipe recipe = mapper.recipeDTOtoRecipe(recipeDTO);
        recipe.setId(id);
        Recipe savedRecipe = repository.save(recipe);
        return mapper.recipeToRecipeDTO(savedRecipe);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Deleting recipe with id: " + id);
        repository.deleteById(id);
    }

    @Override
    public List<RecipeDTO> findAllByPatientId(Long id) {
        log.info("Finding all recipes with patient id: " + id);
        return repository
                .findAllByPatient_Id(id)
                .stream()
                .map(mapper::recipeToRecipeDTO)
                .collect(Collectors.toList());
    }
}
