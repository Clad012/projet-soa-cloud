package com.projetsoacloud.etudiant.service;

import com.projetsoacloud.etudiant.entity.Absence;
import com.projetsoacloud.etudiant.entity.Statistique;
import com.projetsoacloud.etudiant.repository.EtudiantRepository;
import com.projetsoacloud.etudiant.repository.AbsenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AbsenceService {

    @Autowired
    private AbsenceRepository absenceRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Absence saveAbsence(Long etudiantId,Absence absence) {
        log.info("Inside saveAbsence methode of RbsenceService");
        if(absenceRepository.existsByEtudiantIdAndDate(etudiantId, absence.getDate()))
            return updateAbsence(etudiantId,absence);
        else
            return etudiantRepository.findById(etudiantId)
                    .map(etudiant -> {
                        absence.setEtudiant(etudiant);
                        return absenceRepository.save(absence);
                    }).get();
    }

    public List<Absence> findAbsencesByEtudiantId(Long etudiantId) {
        log.info("Inside findAbsencesByEtudiantId methode of AbsenceService");
        return absenceRepository.findByEtudiantId(etudiantId);
    }

    public Absence updateAbsence(Long id, Absence newAbsence) {
        log.info("Inside updateAbsence methode of AbsenceService");
        return absenceRepository.findById(id)
                .map(absence -> {
                    absence.setDate(newAbsence.getDate());
                    absence.setAnneeScolaire(newAbsence.getAnneeScolaire());
                    return absenceRepository.save(absence);
                }).get();
    }

    public Long deleteAbsence(Long id) {
        log.info("Inside deleteAbsence methode of AbsenceService");
        absenceRepository.deleteById(id);
        return id;
    }

    public List<Statistique> countByAnneeScolaire(){
        log.info("Inside countByAnneeScolaire methode of AbsenceService");
        return absenceRepository.countByAnneeScolaire();
    }

    public List<Statistique> countByClasse(String anneeScolaire){
        log.info("Inside countByClasse methode of AbsenceService");
        return absenceRepository.countByClasse(anneeScolaire);
    }

    public List<Statistique> countByEnseignantId(String anneeScolaire){
        log.info("Inside countByEnseignantId methode of AbsenceService");
        return absenceRepository.countByEnseignantId(anneeScolaire);
    }
}
