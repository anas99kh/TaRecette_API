package com.tarecette.api.repositories.mongo;

import com.tarecette.api.entities.Recette;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecetteRepository extends MongoRepository<Recette, String> {
    List<Recette> findByUtilisateurId(String utilisateurId);


}
