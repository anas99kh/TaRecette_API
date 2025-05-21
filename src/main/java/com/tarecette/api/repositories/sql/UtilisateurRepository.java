package com.tarecette.api.repositories.sql;

import com.tarecette.api.entities.Utilisateur;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);

    boolean existsByEmail(@NotNull(message = "L'email ne peut pas être null") @Email(message = "L'email doit être valide") String email);
}
