package com.tarecette.api.services;

import com.tarecette.api.entities.Avis;

import java.util.List;

public interface AvisService {
    Avis createAvis(Avis avis);
    List<Avis> getAllAvis();
    Avis getAvisById(Long id);
//    List<Avis> getAvisByRecetteId(Long recetteId);
    void deleteAvis(Long id);
    Avis updateAvis(Long id, Avis avisDetails);

}
