package com.tarecette.api.repositories.sql;

import com.tarecette.api.entities.Avis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvisRepository extends JpaRepository<Avis, Long> {
//    List<Avis> findByRecetteId(Long recetteId);


}
