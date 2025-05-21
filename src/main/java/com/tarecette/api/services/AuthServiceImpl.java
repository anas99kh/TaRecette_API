package com.tarecette.api.services;

import com.tarecette.api.entities.Utilisateur;
import com.tarecette.api.exceptions.EmailDejaUtiliseException;
import com.tarecette.api.exceptions.IdentifiantsInvalideException;
import com.tarecette.api.repositories.sql.UtilisateurRepository;
import com.tarecette.api.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implémentation des services d'authentification.
 * Cette classe fournit les fonctionnalités d'authentification et d'enregistrement
 * des utilisateurs en utilisant JWT pour la gestion des tokens.
 */
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String login(String email, String password) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurRepository.findByEmail(email);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur utilisateur = optionalUtilisateur.get();
            if (passwordEncoder.matches(password, utilisateur.getPassword())) {
                return jwtUtil.generateToken(email);
            }
        }

        throw new IdentifiantsInvalideException("Nom d'utilisateur ou mot de passe incorrect");
    }

    @Override
    public void register(Utilisateur utilisateur) {
        if (utilisateurRepository.existsByEmail(utilisateur.getEmail())) {
            throw new EmailDejaUtiliseException("Email déjà utilisé !");
        }
        utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
        utilisateurRepository.save(utilisateur);
    }
}
