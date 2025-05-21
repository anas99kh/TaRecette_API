package com.tarecette.api.services;

import com.tarecette.api.entities.PreferenceAlimentaire;

import java.util.List;

public interface PreferenceAlimentaireService {
    PreferenceAlimentaire addPreference(PreferenceAlimentaire preference);
    PreferenceAlimentaire getPreferenceById(Long id);
    List<PreferenceAlimentaire> getAllPreferences();
    PreferenceAlimentaire updatePreference(Long id, PreferenceAlimentaire preference);
    void deletePreference(Long id);
    public List<PreferenceAlimentaire> getPreferencesByUtilisateurId(Long utilisateurId);
}
