package com.tarecette.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ingredients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    private String id;
    @NotBlank(message = "Le nom de l'ingrédient ne peut pas être vide.")
    @Indexed // Index pour le nom
    private String nom;
    @NotBlank(message = "La quantité ne peut pas être vide.")
    private String quantite;

    private String recetteId;

    @DBRef
    private Categorie categorie;





}
