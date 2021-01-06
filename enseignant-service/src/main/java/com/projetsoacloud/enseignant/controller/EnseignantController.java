package com.projetsoacloud.enseignant.controller;

import com.projetsoacloud.enseignant.entity.Enseignant;
import com.projetsoacloud.enseignant.service.EnseignantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enseignants")
@Slf4j
public class EnseignantController {

    @Autowired
    private EnseignantService enseignantService;

    @PostMapping("/")
    public Enseignant saveEnseignant(@RequestBody Enseignant enseignant){
        log.info("Inside saveEnseignant methode of EnseignantController");
        return enseignantService.saveEnseignant(enseignant);
    }


    @GetMapping("/")
    public List<Enseignant> findEnseignants(@RequestParam(name ="grade" , defaultValue = "empty") String grade, @RequestParam(name ="sexe" , defaultValue = "empty") String sexe)
    {
        if(!grade.equals("empty") && !sexe.equals("empty") )
            return enseignantService.findEnseignantsByGradeAndSexe(grade, sexe);
        else if(!grade.equals("empty") || !sexe.equals("empty"))
            return enseignantService.findEnseignantsByGradeOrSexe(grade, sexe);
        else
            return enseignantService.findEnseignants();
    }

    @GetMapping("/{id}")
    public Enseignant findEnseignantById(@PathVariable("id") Long id){
        log.info("Inside findEnseignantById methode of EnseignantController");
        return enseignantService.findEnseignantById(id);
    }

    @PutMapping("/{id}")
    public Enseignant updateEnseignant(@PathVariable("id") Long id, @RequestBody Enseignant enseignant){
        log.info("Inside updateEnseignant methode of EnseignantController");
        return enseignantService.updateEnseignant(id, enseignant);
    }

    @DeleteMapping("/{id}")
    public Long deleteEnseignant(@PathVariable("id") Long id){
        log.info("Inside deleteEnseignant methode of EnseignantController");
        return enseignantService.deleteEnseignant(id);
    }
}
