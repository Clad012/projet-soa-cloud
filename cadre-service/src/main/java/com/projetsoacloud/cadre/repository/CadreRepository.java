package com.projetsoacloud.cadre.repository;

import com.projetsoacloud.cadre.entity.Cadre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CadreRepository extends JpaRepository<Cadre, Long> {

    List<Cadre> findByPosteAndSexe(String poste, String sexe);

    List<Cadre> findByPosteOrSexe(String poste, String sexe);

    List<Cadre> findAll();
}
