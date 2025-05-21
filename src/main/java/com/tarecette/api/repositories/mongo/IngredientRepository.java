package com.tarecette.api.repositories.mongo;

import com.tarecette.api.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IngredientRepository extends MongoRepository<Ingredient, String> {
      List<Ingredient> findByCategorieId(String categorieId);
}
