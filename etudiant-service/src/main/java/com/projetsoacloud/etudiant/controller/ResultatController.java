package com.projetsoacloud.etudiant.controller;

import com.projetsoacloud.etudiant.entity.Resultat;
import com.projetsoacloud.etudiant.entity.Statistique;
import com.projetsoacloud.etudiant.service.ResultatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resultats")
@Slf4j
public class ResultatController {

    @Autowired
    private ResultatService resultatService;

    @PostMapping("/{id}")
    public Resultat saveResultat(@PathVariable("id") Long etudiantId, @RequestBody Resultat resultat){
        log.info("Inside saveResultat methode of ResultatController");
        return resultatService.saveResultat(etudiantId,resultat);
    }

    @GetMapping("/{id}")
    public List<Resultat> findResultatsByEtudiantId(@PathVariable("id") Long etudiantId){
        log.info("Inside findResultatsByEtudiantId methode of ResultatController");
        return resultatService.findResultatsByEtudiantId(etudiantId);
    }

    @PutMapping("/{id}")
    public Resultat updateResultat(@PathVariable("id") Long id, @RequestBody Resultat resultat){
        log.info("Inside updateResultat methode of ResultatController");
        return resultatService.updateResultat(id, resultat);
    }

    @DeleteMapping("/{id}")
    public Long deleteResultat(@PathVariable("id") Long id){
        log.info("Inside deleteResultat methode of ResultatController");
        return resultatService.deleteResultat(id);
    }

    @GetMapping("/statistiques/classe")
    public List<Statistique> countAdmisByClasse(@RequestParam(name ="anneeScolaire") String anneeScolaire){
        log.info("Inside countAdmisByClasse methode of ResultatController");
        return resultatService.countAdmisByClasse(anneeScolaire);
    }

    @GetMapping("/statistiques/sexe")
    public List<Statistique> countAdmisBySexe(@RequestParam(name ="anneeScolaire") String anneeScolaire){
        log.info("Inside countAdmisBySexe methode of ResultatController");
        return resultatService.countAdmisBySexe(anneeScolaire);
    }

    @GetMapping("/statistiques/anneeScolaire")
    public List<Statistique> countAdmisByAnneeScolaire(){
        log.info("Inside countAdmisByAnneeScolaire methode of ResultatController");
        return resultatService.countAdmisByAnneeScolaire();
    }

    @GetMapping("/statistiques/top10")
    public List<Resultat> topresultats(@RequestParam(name ="anneeScolaire") String anneeScolaire){
        log.info("Inside topresultats methode of ResultatController");
        return resultatService.topresultats(anneeScolaire);
    }

}
