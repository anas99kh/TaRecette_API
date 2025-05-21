package com.tarecette.api.web;

import com.tarecette.api.entities.Avis;
import com.tarecette.api.services.AvisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/avis")
public class AvisController {
    @Autowired
    private AvisService avisService;

    @PostMapping
    public ResponseEntity<Avis> createAvis(@RequestBody Avis avis) {
        Avis createdAvis = avisService.createAvis(avis);
        return ResponseEntity.status(201).body(createdAvis);
    }
    @GetMapping
    public List<Avis> getAllAvis() {
        return avisService.getAllAvis();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Avis> getAvisById(@PathVariable Long id) {
        Avis avis = avisService.getAvisById(id);
        return avis != null ? ResponseEntity.ok(avis) : ResponseEntity.notFound().build();
    }
//    @GetMapping("/recette/{recetteId}")
//    public List<Avis> getAvisByRecetteId(@PathVariable Long recetteId) {
//        return avisService.getAvisByRecetteId(recetteId);
//    }
@PutMapping("/{id}")
public ResponseEntity<Avis> updateAvis(
        @PathVariable Long id,
        @RequestBody Avis avisDetails) {
    Avis updatedAvis = avisService.updateAvis(id, avisDetails);
    return ResponseEntity.ok(updatedAvis);
}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvis(@PathVariable Long id) {
        avisService.deleteAvis(id);
        return ResponseEntity.noContent().build();
    }

}
