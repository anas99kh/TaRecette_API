package com.tarecette.api.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recettes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Recette {
    @Id
    private String id;
    @NotBlank(message = "Le titre ne peut pas être vide.")
    @Indexed(unique = true)
    private String titre;
    @NotBlank(message = "La description ne peut pas être vide.")
    private String description;
    @NotBlank(message = "Le temps de préparation ne peut pas être vide.")
    private String tempsDePreparation;
    @NotBlank(message = "Le temps de cuisson ne peut pas être vide.")
    private String tempsDeCuisson;
    @NotNull(message = "La difficulté ne peut pas être nulle.")
    private String difficulte;
    private String imageUrl;

    private String utilisateurId;

//    @ManyToOne
//    @JoinColumn(name = "utilisateur_id")
//    @JsonIgnore
//    private Utilisateur utilisateur;

//    @ManyToMany
//    @JoinTable(
//            name = "recette_ingredient",
//            joinColumns = @JoinColumn(name = "recette_id"),
//            inverseJoinColumns = @JoinColumn(name = "ingredient_id")
//    )
//    private List<Ingredient> ingredients;
//
//    @OneToMany(mappedBy = "recette")
//    private List<Avis> avis;



}
