package com.tarecette.api.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Avis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Min(1)
    @Max(5)
    private int note;

    @Lob
    private String commentaire;

    private LocalDateTime dateCreation = LocalDateTime.now();

//    @ManyToOne
//    @JoinColumn(name = "recette_id")
//    private Recette recette;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "utilisateur_id",nullable = false)
    private Utilisateur utilisateur;


}
