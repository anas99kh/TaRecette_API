package com.tarecette.api.web;

import com.tarecette.api.entities.Categorie;
import com.tarecette.api.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;

    @PostMapping
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
        Categorie createdCategorie = categorieService.addCategorie(categorie);
        return ResponseEntity.status(201).body(createdCategorie);
    }
    @GetMapping
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable String id) {
        Categorie categorie = categorieService.getCategorieById(id);
        return categorie != null ? ResponseEntity.ok(categorie) : ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categorie> updateCategorie(
            @PathVariable String id,
            @RequestBody Categorie categorieDetails) {
        Categorie updatedCategorie = categorieService.updateCategorie(id, categorieDetails);
        return ResponseEntity.ok(updatedCategorie);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable String id) {
        categorieService.deleteCategorie(id);
        return ResponseEntity.noContent().build();
    }
}
