package com.nacu.medicaloffices.controllers;

import com.nacu.medicaloffices.api.model.RecipeDTO;
import com.nacu.medicaloffices.services.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RecipeController.BASE_URL)
public class RecipeController {

    public static final String BASE_URL = "/api/recipes";

    private final RecipeService service;

    public RecipeController(RecipeService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RecipeDTO> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RecipeDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RecipeDTO create(@RequestBody RecipeDTO recipeDTO) {
        return service.create(recipeDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RecipeDTO update(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {
        return service.saveById(id, recipeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/patient/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<RecipeDTO> getAllByPatientId(@PathVariable Long id) {
        return service.findAllByPatientId(id);
    }
}
