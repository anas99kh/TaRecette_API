package com.tarecette.api.services;

import com.tarecette.api.entities.Utilisateur;
import com.tarecette.api.exceptions.EmailDejaUtiliseException;
import com.tarecette.api.repositories.sql.UtilisateurRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id).orElse(null);
    }


    @Override
    public Utilisateur addUtilisateur(@Valid Utilisateur utilisateur) {
        // Vérifie si l'utilisateur existe déjà par email
        if (utilisateurRepository.findByEmail(utilisateur.getEmail()).isPresent()) {
            throw new EmailDejaUtiliseException("L'email est déjà utilisé.");
        }
        return utilisateurRepository.save(utilisateur);
    }
    public Utilisateur updateUtilisateur(Long id, Utilisateur utilisateurDetails) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateurToUpdate = optionalUtilisateur.get();
            utilisateurToUpdate.setNom(utilisateurDetails.getNom());
            utilisateurToUpdate.setEmail(utilisateurDetails.getEmail());
            // Mettez à jour d'autres champs selon besoin
            return utilisateurRepository.save(utilisateurToUpdate);
        } else {
            throw new RuntimeException("Utilisateur non trouvé avec id : " + id);
        }
    }
    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }
}
