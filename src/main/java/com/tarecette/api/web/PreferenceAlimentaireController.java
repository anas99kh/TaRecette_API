package com.tarecette.api.web;

import com.tarecette.api.entities.PreferenceAlimentaire;
import com.tarecette.api.services.PreferenceAlimentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/preferences")
public class PreferenceAlimentaireController {
    @Autowired
    private PreferenceAlimentaireService preferenceAlimentaireService;

    @PostMapping
    public ResponseEntity<PreferenceAlimentaire> createPreference(@RequestBody PreferenceAlimentaire preference) {
        PreferenceAlimentaire createdPreference = preferenceAlimentaireService.addPreference(preference);
        return new ResponseEntity<>(createdPreference, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PreferenceAlimentaire> getPreferenceById(@PathVariable Long id) {
        PreferenceAlimentaire preference = preferenceAlimentaireService.getPreferenceById(id);
        if (preference != null) {
            return new ResponseEntity<>(preference, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping
    public ResponseEntity<List<PreferenceAlimentaire>> getAllPreferences() {
        List<PreferenceAlimentaire> preferences = preferenceAlimentaireService.getAllPreferences();
        return new ResponseEntity<>(preferences, HttpStatus.OK);
    }
    @GetMapping("/utilisateur/{utilisateurId}")
    public ResponseEntity<List<PreferenceAlimentaire>> getPreferencesParUtilisateurId(@PathVariable Long utilisateurId) {
        List<PreferenceAlimentaire> preferences = preferenceAlimentaireService.getPreferencesByUtilisateurId(utilisateurId);
        return ResponseEntity.ok(preferences);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PreferenceAlimentaire> updatePreference(@PathVariable Long id, @RequestBody PreferenceAlimentaire preference) {
        PreferenceAlimentaire updatedPreference = preferenceAlimentaireService.updatePreference(id, preference);
        if (updatedPreference != null) {
            return new ResponseEntity<>(updatedPreference, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePreference(@PathVariable Long id) {
        preferenceAlimentaireService.deletePreference(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
