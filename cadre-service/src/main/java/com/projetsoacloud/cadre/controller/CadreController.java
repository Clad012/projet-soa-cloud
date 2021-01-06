package com.projetsoacloud.cadre.controller;

import com.projetsoacloud.cadre.entity.Cadre;
import com.projetsoacloud.cadre.service.CadreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadres")
@Slf4j
public class CadreController {

    @Autowired
    private CadreService cadreService;

    @PostMapping("/")
    public Cadre saveCadre(@RequestBody Cadre cadre){
        log.info("Inside saveCadre methode of CadreController");
        return cadreService.saveCadre(cadre);
    }

    @GetMapping("/")
    public List<Cadre> findCadres(@RequestParam(name ="poste" , defaultValue = "empty") String poste, @RequestParam(name ="sexe" , defaultValue = "empty") String sexe)
    {
        if(!poste.equals("empty") && !sexe.equals("empty") )
            return cadreService.findCadresByPosteAndSexe(poste, sexe);
        else if(!poste.equals("empty") || !sexe.equals("empty"))
            return cadreService.findCadresByPosteOrSexe(poste, sexe);
        else
            return cadreService.findCadres();
    }

    @GetMapping("/{id}")
    public Cadre findCadreById(@PathVariable("id") Long id){
        log.info("Inside findCadreById methode of CadreController");
        return cadreService.findCadreById(id);
    }

    @PutMapping("/{id}")
    public Cadre updateCadre(@PathVariable("id") Long id,@RequestBody Cadre cadre){
        log.info("Inside updateCadre methode of CadreController");
        return cadreService.updateCadre(id, cadre);
    }

    @DeleteMapping("/{id}")
    public Long deleteCadre(@PathVariable("id") Long id){
        log.info("Inside deleteCadre methode of CadreController");
        return cadreService.deleteCadre(id);
    }
}
