package com.tarecette.api.repositories.sql;

import com.tarecette.api.entities.PreferenceAlimentaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreferenceAlimentaireRepository extends JpaRepository<PreferenceAlimentaire, Long> {
    List<PreferenceAlimentaire> findByUtilisateurId(Long utilisateurId);
}
