package com.projetsoacloud.enseignant.repository;

import com.projetsoacloud.enseignant.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

    List<Enseignant> findByGradeAndSexe(String grade, String sexe);

    List<Enseignant> findByGradeOrSexe(String grade, String sexe);

    List<Enseignant> findAll();
}
