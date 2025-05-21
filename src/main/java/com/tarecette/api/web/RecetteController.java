package com.tarecette.api.web;

import com.tarecette.api.entities.Recette;
import com.tarecette.api.services.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recettes")
public class RecetteController {
    @Autowired
    private RecetteService recetteService;

    @GetMapping
    public List<Recette> getAllRecettes() {
        return recetteService.getAllRecettes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recette> getRecetteById(@PathVariable String id) {
        Recette recette = recetteService.getRecetteById(id);
        return recette != null ? ResponseEntity.ok(recette) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Recette createRecette(@RequestBody Recette recette) {
        return recetteService.createRecette(recette);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recette> updateRecette(@PathVariable String id, @RequestBody Recette recetteDetails) {
        Recette updatedRecette = recetteService.updateRecette(id, recetteDetails);
        return ResponseEntity.ok(updatedRecette);
    }
    @GetMapping("/utilisateur/{utilisateurId}")
    public ResponseEntity<List<Recette>> getRecettesByUtilisateur(@PathVariable String utilisateurId) {
        List<Recette> recettes = recetteService.getRecettesByUtilisateurId(utilisateurId);
        return ResponseEntity.ok(recettes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecette(@PathVariable String id) {
        recetteService.deleteRecette(id);
        return ResponseEntity.noContent().build();
    }

}
