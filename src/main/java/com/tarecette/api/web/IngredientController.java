package com.tarecette.api.web;

import com.tarecette.api.entities.Ingredient;
import com.tarecette.api.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<Ingredient> addIngredient(
            @RequestBody Ingredient ingredient,
            @RequestParam String categorieId) {
        Ingredient savedIngredient = ingredientService.addIngredient(ingredient, categorieId);
        return ResponseEntity.ok(savedIngredient);
    }
    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientService.getAllIngredients();
        return ResponseEntity.ok(ingredients);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable String id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        return ingredient != null ? ResponseEntity.ok(ingredient) : ResponseEntity.notFound().build();
    }
    @GetMapping("/categorie/{categorieId}")
    public ResponseEntity<List<Ingredient>> getIngredientsByCategorie(@PathVariable String categorieId) {
        List<Ingredient> ingredients = ingredientService.getIngredientsByCategorie(categorieId);
        return ResponseEntity.ok(ingredients);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Ingredient> updateIngredient(
            @PathVariable String id,
            @RequestBody Ingredient ingredientDetails) {
        Ingredient updatedIngredient = ingredientService.updateIngredient(id, ingredientDetails);
        return ResponseEntity.ok(updatedIngredient);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable String id) {
        ingredientService.deleteIngredient(id);
        return ResponseEntity.noContent().build();
    }


}
