package com.tarecette.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id
    private String id;
    @NotBlank(message = "Le nom de la catégorie ne peut pas être vide.")
    @Indexed(unique = true) // Index unique pour le nom
    private String nom;

//    @OneToMany(mappedBy = "categorie") // Relation inverse
//    private Set<Ingredient> ingredients;
}
