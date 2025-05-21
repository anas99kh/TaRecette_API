package com.tarecette.api.services;

import com.tarecette.api.entities.Utilisateur;
import com.tarecette.api.repositories.sql.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Service d'implémentation de UserDetailsService pour Spring Security.
 * Cette classe charge les détails de l'utilisateur à partir de la base de données
 * pour l'authentification Spring Security.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé avec l'email: " + email));

        // Pour l'instant, nous n'utilisons pas de rôles/autorités spécifiques, donc une liste vide.
        // Si vous avez des rôles, vous devrez les charger ici et les convertir en GrantedAuthority.
        return new User(
                utilisateur.getEmail(),
                utilisateur.getPassword(),
                Collections.emptyList()
        );
    }
}
