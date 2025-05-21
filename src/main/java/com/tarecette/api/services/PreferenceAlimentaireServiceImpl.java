package com.tarecette.api.services;

import com.tarecette.api.entities.PreferenceAlimentaire;
import com.tarecette.api.repositories.sql.PreferenceAlimentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreferenceAlimentaireServiceImpl implements PreferenceAlimentaireService {
    @Autowired
    private PreferenceAlimentaireRepository preferenceAlimentaireRepository;

    @Override
    public PreferenceAlimentaire addPreference(PreferenceAlimentaire preference) {
        return preferenceAlimentaireRepository.save(preference);
    }

    @Override
    public PreferenceAlimentaire getPreferenceById(Long id) {
        return preferenceAlimentaireRepository.findById(id).orElse(null);
    }

    @Override
    public List<PreferenceAlimentaire> getAllPreferences() {
        return preferenceAlimentaireRepository.findAll();
    }

    @Override
    public PreferenceAlimentaire updatePreference(Long id, PreferenceAlimentaire preference) {
        if (preferenceAlimentaireRepository.existsById(id)) {
            preference.setId(id);
            return preferenceAlimentaireRepository.save(preference);
        }
        return null; // Ou lance une exception
    }

    @Override
    public void deletePreference(Long id) {
        preferenceAlimentaireRepository.deleteById(id);
    }

    @Override
    public List<PreferenceAlimentaire> getPreferencesByUtilisateurId(Long utilisateurId) {
        return preferenceAlimentaireRepository.findByUtilisateurId(utilisateurId);
    }
}
