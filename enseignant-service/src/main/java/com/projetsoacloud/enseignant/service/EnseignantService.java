package com.projetsoacloud.enseignant.service;

import com.projetsoacloud.enseignant.entity.Enseignant;
import com.projetsoacloud.enseignant.repository.EnseignantRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;

    public Enseignant saveEnseignant(Enseignant enseignant) {
        log.info("Inside saveEnseignant methode of EnseignantService");
        return enseignantRepository.save(enseignant);
    }

    public List<Enseignant> findEnseignants() {
        log.info("Inside findEnseignants methode of EnseignantService");
        return enseignantRepository.findAll();
    }

    public Enseignant findEnseignantById(Long id) {
        log.info("Inside findEnseignantById methode of EnseignantService");
        return enseignantRepository.findById(id).get();
    }

    public List<Enseignant> findEnseignantsByGradeAndSexe(String grade, String sexe) {
        log.info("Inside findEnseignantsByGradeAndSexe methode of EnseignantService");
        return enseignantRepository.findByGradeAndSexe(grade,sexe);
    }

    public List<Enseignant> findEnseignantsByGradeOrSexe(String grade, String sexe) {
        log.info("Inside findEnseignantsByGradeOrSexe methode of EnseignantService");
        return enseignantRepository.findByGradeOrSexe(grade,sexe);
    }

    public Enseignant updateEnseignant(Long id, Enseignant newEnseignant) {
        log.info("Inside updateEnseignant methode of EnseignantService");
        return enseignantRepository.findById(id)
                .map(enseignant -> {
                    enseignant.setNom(newEnseignant.getNom());
                    enseignant.setPrenom(newEnseignant.getPrenom());
                    enseignant.setDate_naissance(newEnseignant.getDate_naissance());
                    enseignant.setGrade(newEnseignant.getGrade());
                    enseignant.setSexe(newEnseignant.getSexe());
                    enseignant.setEmail(newEnseignant.getEmail());
                    return enseignantRepository.save(enseignant);
                }).get();
    }

    public Long deleteEnseignant(Long id) {
        log.info("Inside deleteEnseignant methode of EnseignantService");
        enseignantRepository.deleteById(id);
        return id;
    }
}
