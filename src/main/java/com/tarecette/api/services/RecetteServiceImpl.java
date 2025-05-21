package com.tarecette.api.services;

import com.tarecette.api.entities.PreferenceAlimentaire;
import com.tarecette.api.entities.Recette;
import com.tarecette.api.entities.Utilisateur;
import com.tarecette.api.repositories.mongo.RecetteRepository;
import com.tarecette.api.repositories.sql.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetteServiceImpl implements RecetteService {
    @Autowired
    private RecetteRepository recetteRepository;
    private UtilisateurRepository utilisateurRepository;


    @Override
    public List<Recette> getAllRecettes() {
        return recetteRepository.findAll();
    }

    @Override
    public Recette getRecetteById(String id) {
        return recetteRepository.findById(id).orElse(null);
    }

    @Override
    public Recette createRecette(Recette recette) {
        return recetteRepository.save(recette);
    }

    @Override
    public void deleteRecette(String id) {
        recetteRepository.deleteById(id);

    }

    @Override
    public List<PreferenceAlimentaire> getPreferencesByUtilisateurId(Long utilisateurId) {
        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurId).orElse(null);
        return utilisateur != null ? utilisateur.getPreferences() : null;
    }

    @Override
    public Recette updateRecette(String id, Recette recetteDetails) {
        Optional<Recette> optionalRecette = recetteRepository.findById(id);
        if (optionalRecette.isPresent()) {
            Recette recetteToUpdate = optionalRecette.get();
            recetteToUpdate.setTitre(recetteDetails.getTitre());
            recetteToUpdate.setDescription(recetteDetails.getDescription());
            recetteToUpdate.setTempsDePreparation(recetteDetails.getTempsDePreparation());
            recetteToUpdate.setTempsDeCuisson(recetteDetails.getTempsDeCuisson());
            recetteToUpdate.setDifficulte(recetteDetails.getDifficulte());
            return recetteRepository.save(recetteToUpdate);
        } else {
            throw new RuntimeException("Recette non trouvée avec id : " + id);
        }
    }

    @Override
    public List<Recette> getRecettesByUtilisateurId(String utilisateurId) {
        return recetteRepository.findByUtilisateurId(utilisateurId);
    }
}


