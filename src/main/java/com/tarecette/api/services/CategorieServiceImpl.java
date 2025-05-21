package com.tarecette.api.services;


import com.tarecette.api.entities.Categorie;

import com.tarecette.api.repositories.mongo.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    private CategorieRepository categorieRepository;


    @Override
    public Categorie addCategorie(Categorie categorie) {
       return categorieRepository.save(categorie);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie getCategorieById(String id) {
        return categorieRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCategorie(String id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie updateCategorie(String id, Categorie categorieDetails) {
        Categorie existingCategorie = categorieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec id : " + id));

        existingCategorie.setNom(categorieDetails.getNom());
        return categorieRepository.save(existingCategorie);
    }

}
