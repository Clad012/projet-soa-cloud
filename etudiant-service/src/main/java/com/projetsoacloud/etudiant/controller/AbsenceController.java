package com.projetsoacloud.etudiant.controller;

import com.projetsoacloud.etudiant.entity.Absence;
import com.projetsoacloud.etudiant.entity.Statistique;
import com.projetsoacloud.etudiant.service.AbsenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absences")
@Slf4j
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    @PostMapping("/{id}")
    public Absence saveAbsence(@PathVariable("id") Long etudiantId, @RequestBody Absence absence){
        log.info("Inside saveAbsence methode of AbsenceController");
        return absenceService.saveAbsence(etudiantId,absence);
    }

    @GetMapping("/{id}")
    public List<Absence> findAbsencesByEtudiantId(@PathVariable("id") Long etudiantId){
        log.info("Inside findAbsencesByEtudiantId methode of AbsenceController");
        return absenceService.findAbsencesByEtudiantId(etudiantId);
    }


    @PutMapping("/{id}")
    public Absence updateAbsence(@PathVariable("id") Long id, @RequestBody Absence absence){
        log.info("Inside updateAbsence methode of AbsenceController");
        return absenceService.updateAbsence(id, absence);
    }


    @DeleteMapping("/{id}")
    public Long deleteAbsence(@PathVariable("id") Long id){
        log.info("Inside deleteAbsence methode of AbsenceController");
        return absenceService.deleteAbsence(id);
    }

    @GetMapping("/statistiques/classe")
    public List<Statistique> countByClasse(@RequestParam(name ="anneeScalaire") String anneeScolaire){
        log.info("Inside countByClasse methode of AbsenceController");
        return absenceService.countByClasse(anneeScolaire);
    }

    @GetMapping("/statistiques/anneeScolaire")
    public List<Statistique> countByAnneeScolaire(){
        log.info("Inside countByAnneeScolaire methode of AbsenceController");
        return absenceService.countByAnneeScolaire();
    }

    @GetMapping("/statistiques/enseignant")
    public List<Statistique> countByEnseignantId(@RequestParam(name ="anneeScalaire") String anneeScolaire){
        log.info("Inside countByEnseignantId methode of AbsenceController");
        return absenceService.countByEnseignantId(anneeScolaire);
    }



}
