package com.tarecette.api.services;

import com.tarecette.api.entities.Categorie;
import com.tarecette.api.entities.Ingredient;
import com.tarecette.api.repositories.mongo.CategorieRepository;
import com.tarecette.api.repositories.mongo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private CategorieRepository categorieRepository;

    public Ingredient addIngredient(Ingredient ingredient, String categorieId) {
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée"));
        ingredient.setCategorie(categorie);
        return ingredientRepository.save(ingredient);
    }
    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getIngredientById(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteIngredient(String id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public List<Ingredient> getIngredientsByCategorie(String categorieId) {
        return ingredientRepository.findByCategorieId(categorieId);
    }

    @Override
    public Ingredient updateIngredient(String id, Ingredient ingredientDetails) {
        Ingredient existingIngredient = ingredientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ingrédient non trouvé avec id : " + id));

        existingIngredient.setNom(ingredientDetails.getNom());
        existingIngredient.setQuantite(ingredientDetails.getQuantite());
        // Mettez à jour d'autres champs si nécessaire

        return ingredientRepository.save(existingIngredient);
    }

//    @Override
//    public List<Ingredient> getIngredientsByCategorieId(Long categorieId) {
//        return ingredientRepository.findByCategorieId(categorieId);
//    }
}
