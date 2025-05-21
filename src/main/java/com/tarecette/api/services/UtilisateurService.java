package com.tarecette.api.services;

import com.tarecette.api.entities.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    List<Utilisateur> getAllUtilisateurs();
    Utilisateur getUtilisateurById(Long id);
    Utilisateur addUtilisateur(Utilisateur utilisateur);
    void deleteUtilisateur(Long id);
    Utilisateur updateUtilisateur(Long id, Utilisateur utilisateurDetails);
}

