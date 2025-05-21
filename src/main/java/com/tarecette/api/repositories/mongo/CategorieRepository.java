package com.tarecette.api.repositories.mongo;

import com.tarecette.api.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategorieRepository extends MongoRepository<Categorie, String> {

}
