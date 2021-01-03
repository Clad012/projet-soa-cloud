package com.projetsoacloud.etudiant.controller;

import com.projetsoacloud.etudiant.entity.Etudiant;
import com.projetsoacloud.etudiant.service.EtudiantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiants")
@Slf4j
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping("/")
    public Etudiant saveEtudiant(@RequestBody Etudiant etudiant){
        log.info("Inside saveEtudiant methode of EtudiantController");
        return etudiantService.saveEtudiant(etudiant);
    }

    @GetMapping("/")
    public List<Etudiant> findEtudiants(@RequestParam(name ="classe" , defaultValue = "empty") String classe, @RequestParam(name ="sexe" , defaultValue = "empty") String sexe)
    {
        if(!classe.equals("empty") && !sexe.equals("empty") )
            return etudiantService.findEtudiantsByClasseAndSexe(classe, sexe);
        else if(!classe.equals("empty") || !sexe.equals("empty"))
            return etudiantService.findEtudiantsByClasseOrSexe(classe, sexe);
        else
            return etudiantService.findEtudiants();
    }


    @GetMapping("/{id}")
    public Etudiant findEtudiantById(@PathVariable("id") Long id){
        log.info("Inside findEtudiantById methode of EtudiantController");
        return etudiantService.findEtudiantById(id);
    }


    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable("id") Long id, @RequestBody Etudiant etudiant){
        log.info("Inside updateEtudiant methode of EtudiantController");
        return etudiantService.updateEtudiant(id, etudiant);
    }


    @DeleteMapping("/{id}")
    public Long deleteEtudiant(@PathVariable("id") Long id){
        log.info("Inside deleteEtudiant methode of EtudiantController");
        return etudiantService.deleteEtudiant(id);
    }

}
