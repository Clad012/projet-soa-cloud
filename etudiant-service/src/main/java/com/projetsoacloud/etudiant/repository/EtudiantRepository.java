package com.projetsoacloud.etudiant.repository;

import com.projetsoacloud.etudiant.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    List<Etudiant> findByClasseAndSexeOrderByNomAscPrenomAsc(String classe, String sexe);

    List<Etudiant> findByClasseOrSexeOrderByNomAscPrenomAsc(String classe, String sexe);

    List<Etudiant> findAllByOrderByNomAscPrenomAsc();
}
