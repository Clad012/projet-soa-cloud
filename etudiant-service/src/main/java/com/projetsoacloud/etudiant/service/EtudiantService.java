package com.projetsoacloud.etudiant.service;

import com.projetsoacloud.etudiant.entity.Etudiant;
import com.projetsoacloud.etudiant.repository.EtudiantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Etudiant saveEtudiant(Etudiant etudiant) {
        log.info("Inside saveEtudiant methode of EtudiantService");
        return etudiantRepository.save(etudiant);
    }

    public List<Etudiant> findEtudiants() {
        log.info("Inside findEtudiants methode of EtudiantService");
        return etudiantRepository.findAllByOrderByNomAscPrenomAsc();
    }

    public Etudiant findEtudiantById(Long id) {
        log.info("Inside findEtudiantById methode of EtudiantService");
        return etudiantRepository.findById(id).get();
    }

    public List<Etudiant> findEtudiantsByClasseAndSexe(String classe, String sexe) {
        log.info("Inside findEtudiantsByClasseAndSexe methode of EtudiantService");
        return etudiantRepository.findByClasseAndSexeOrderByNomAscPrenomAsc(classe,sexe);
    }

    public List<Etudiant> findEtudiantsByClasseOrSexe(String classe, String sexe) {
        log.info("Inside findEtudiantsByClasseOrSexe methode of EtudiantService");
        return etudiantRepository.findByClasseOrSexeOrderByNomAscPrenomAsc(classe,sexe);
    }

    public Etudiant updateEtudiant(Long id, Etudiant newEtudiant) {
        log.info("Inside updateEtudiant methode of EtudiantService");
        return etudiantRepository.findById(id)
                .map(etudiant -> {
                    etudiant.setNom(newEtudiant.getNom());
                    etudiant.setPrenom(newEtudiant.getPrenom());
                    etudiant.setDate_naissance(newEtudiant.getDate_naissance());
                    etudiant.setClasse(newEtudiant.getClasse());
                    etudiant.setSexe(newEtudiant.getSexe());
                    etudiant.setEmail(newEtudiant.getEmail());
                    return etudiantRepository.save(etudiant);
                }).get();
    }

    public Long deleteEtudiant(Long id) {
        log.info("Inside deleteEtudiant methode of EtudiantService");
        etudiantRepository.deleteById(id);
        return id;
    }
}
