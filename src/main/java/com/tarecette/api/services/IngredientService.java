package com.tarecette.api.services;

import com.tarecette.api.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    Ingredient addIngredient(Ingredient ingredient,String categorieId);
    List<Ingredient> getAllIngredients();
    Ingredient getIngredientById(String id);
    void deleteIngredient(String id);
//    List<Ingredient> getIngredientsByCategorieId(Long categorieId);
public List<Ingredient> getIngredientsByCategorie(String categorieId) ;
    Ingredient updateIngredient(String id, Ingredient ingredientDetails);

}
