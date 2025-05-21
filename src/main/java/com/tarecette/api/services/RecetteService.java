package com.tarecette.api.services;

import com.tarecette.api.entities.PreferenceAlimentaire;
import com.tarecette.api.entities.Recette;

import java.util.List;

public interface RecetteService {
    List<Recette> getAllRecettes();
    Recette getRecetteById(String id);
    Recette createRecette(Recette recette);
    void deleteRecette(String id);
    List<PreferenceAlimentaire> getPreferencesByUtilisateurId(Long utilisateurId);
    Recette updateRecette(String id, Recette recetteDetails);
    List<Recette> getRecettesByUtilisateurId(String utilisateurId);
}
