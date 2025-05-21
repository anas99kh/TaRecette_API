package com.tarecette.api.services;

import com.tarecette.api.entities.Categorie;

import java.util.List;

public interface CategorieService {
    Categorie addCategorie(Categorie categorie);
    List<Categorie> getAllCategories();
    Categorie getCategorieById(String id);
    void deleteCategorie(String id);
    Categorie updateCategorie(String id, Categorie categorieDetails);
}
