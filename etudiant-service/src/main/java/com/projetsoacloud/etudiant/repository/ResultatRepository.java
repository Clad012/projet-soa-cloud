package com.projetsoacloud.etudiant.repository;

import com.projetsoacloud.etudiant.entity.Resultat;
import com.projetsoacloud.etudiant.entity.Statistique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat, Long> {

    List<Resultat> findByEtudiantId(Long etudiantId);

    boolean existsByEtudiantIdAndAnneeScolaire(Long etudiantId, String annee_scolaire);

    @Query("SELECT " +
            "    new com.projetsoacloud.etudiant.entity.Statistique(r.etudiant.classe, COUNT(r.id)) " +
            "FROM " +
            "    Resultat r " +
            "WHERE " +
            "    r.anneeScolaire = ?1 " +
            "AND " +
            "    r.moyenne >= 10 " +
            "GROUP BY " +
            "    r.etudiant.classe ")
    List<Statistique> countAdmisByClasse(String anneeScolaire);

    @Query("SELECT " +
            "    new com.projetsoacloud.etudiant.entity.Statistique(r.etudiant.classe, COUNT(r.id)) " +
            "FROM " +
            "    Resultat r " +
            "WHERE " +
            "    r.anneeScolaire = ?1 " +
            "GROUP BY " +
            "    r.etudiant.classe ")
    List<Statistique> countAllByClasse(String anneeScolaire);


    @Query("SELECT " +
            "    new com.projetsoacloud.etudiant.entity.Statistique(r.etudiant.sexe, COUNT(r.id)) " +
            "FROM " +
            "    Resultat r " +
            "WHERE " +
            "    r.anneeScolaire = ?1 " +
            "AND " +
            "    r.moyenne >= 10 " +
            "GROUP BY " +
            "    r.etudiant.sexe ")
    List<Statistique> countAdmisBySexe(String anneeScolaire);

    @Query("SELECT " +
            "    new com.projetsoacloud.etudiant.entity.Statistique(r.etudiant.sexe, COUNT(r.id)) " +
            "FROM " +
            "    Resultat r " +
            "WHERE " +
            "    r.anneeScolaire = ?1 " +
            "GROUP BY " +
            "    r.etudiant.sexe ")
    List<Statistique> countAllBySexe(String anneeScolaire);


    @Query("SELECT " +
            "    new com.projetsoacloud.etudiant.entity.Statistique(r.anneeScolaire, COUNT(r.id)) " +
            "FROM " +
            "    Resultat r " +
            "WHERE " +
            "    r.moyenne >= 10 " +
            "GROUP BY " +
            "    r.anneeScolaire " + " ORDER BY r.anneeScolaire ASC")
    List<Statistique> countAdmisByAnneScolaire();

    @Query("SELECT " +
            "    new com.projetsoacloud.etudiant.entity.Statistique(r.anneeScolaire, COUNT(r.id)) " +
            "FROM " +
            "    Resultat r " +
            "GROUP BY " +
            "    r.anneeScolaire " + " ORDER BY r.anneeScolaire ASC")
    List<Statistique> countAllByAnneeScolaire();


    List<Resultat> findTop10ByAnneeScolaireOrderByMoyenneDesc(String annee_scolaire);
}
