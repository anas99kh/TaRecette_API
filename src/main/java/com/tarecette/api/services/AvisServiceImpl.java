package com.tarecette.api.services;

import com.tarecette.api.entities.Avis;
import com.tarecette.api.repositories.sql.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisServiceImpl implements AvisService {
    @Autowired
    private AvisRepository avisRepository;


    @Override
    public Avis createAvis(Avis avis) {
        return avisRepository.save(avis);
    }

    @Override
    public List<Avis> getAllAvis() {
        return avisRepository.findAll();
    }

    @Override
    public Avis getAvisById(Long id) {
        return avisRepository.findById(id).orElse(null);
    }

//    @Override
//    public List<Avis> getAvisByRecetteId(Long recetteId) {
//        return avisRepository.findByRecetteId(recetteId);
//    }

    @Override
    public void deleteAvis(Long id) {
        avisRepository.deleteById(id);
    }

    @Override
    public Avis updateAvis(Long id, Avis avisDetails) {
        Avis existingAvis = avisRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avis non trouvé avec id : " + id));

        existingAvis.setCommentaire(avisDetails.getCommentaire());
        existingAvis.setNote(avisDetails.getNote());
        return avisRepository.save(existingAvis);
    }
}
