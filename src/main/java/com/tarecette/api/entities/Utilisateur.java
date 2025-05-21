package com.tarecette.api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Le nom ne peut pas être null")
    private String nom;
    @NotNull(message = "L'email ne peut pas être null")
    @Email(message = "L'email doit être valide")
    private String email;
    @NotNull(message = "Le mot de passe ne peut pas être null")
    @Size(min = 6, message = "Le mot de passe doit contenir au moins 6 caractères")
    private String password;

//    @OneToMany(mappedBy = "utilisateur")
//    private Set<Recette> recettes;

    @OneToMany(mappedBy = "utilisateur")
    private List<PreferenceAlimentaire> preferences;

    @OneToMany(mappedBy = "utilisateur")
    private List<Avis> avis;





}
