package com.projetsoacloud.etudiant.repository;

import com.projetsoacloud.etudiant.entity.Absence;
import com.projetsoacloud.etudiant.entity.Resultat;
import com.projetsoacloud.etudiant.entity.Statistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {

    List<Absence> findByEtudiantId(Long etudiantId);

    boolean existsByEtudiantIdAndDate(Long etudiantId, String date);

    @Query("SELECT " +
            "    new com.projetsoacloud.etudiant.entity.Statistique(a.anneeScolaire, COUNT(a.id)) " +
            "FROM " +
            "    Absence a " +
            "GROUP BY " +
            "    a.anneeScolaire ")
    List<Statistique> countByAnneeScolaire();


    @Query("SELECT " +
            "    new com.projetsoacloud.etudiant.entity.Statistique(a.etudiant.classe, COUNT(a.id)) " +
            "FROM " +
            "    Absence a " +
            "WHERE " +
            "    a.anneeScolaire = ?1 " +
            "GROUP BY " +
            "    a.etudiant.classe ")
    List<Statistique> countByClasse(String anneeScolaire);

    @Query("SELECT " +
            "    new com.projetsoacloud.etudiant.entity.Statistique(a.date, COUNT(a.id)) " +
            "FROM " +
            "    Absence a " +
            "WHERE " +
            "    a.anneeScolaire = ?1 " +
            "GROUP BY " +
            "    a.date ")
    List<Statistique> countByDate(String anneeScolaire);
}
