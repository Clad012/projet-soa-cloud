package com.projetsoacloud.cadre.service;

import com.projetsoacloud.cadre.entity.Cadre;
import com.projetsoacloud.cadre.repository.CadreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CadreService {

    @Autowired
    private CadreRepository cadreRepository;

    public Cadre saveCadre(Cadre cadre) {
        log.info("Inside saveCadre methode of CadreService");
        return cadreRepository.save(cadre);
    }

    public List<Cadre> findCadres() {
        log.info("Inside findCadres methode of CadreService");
        return cadreRepository.findAll();
    }

    public Cadre findCadreById(Long id) {
        log.info("Inside findCadreById methode of CadreService");
        return cadreRepository.findById(id).get();
    }

    public List<Cadre> findCadresByPosteAndSexe(String poste, String sexe) {
        log.info("Inside findCadresByPosteAndSexe methode of CadreService");
        return cadreRepository.findByPosteAndSexe(poste,sexe);
    }

    public List<Cadre> findCadresByPosteOrSexe(String poste, String sexe) {
        log.info("Inside findCadresByPosteOrSexe methode of CadreService");
        return cadreRepository.findByPosteOrSexe(poste,sexe);
    }

    public Cadre updateCadre(Long id, Cadre newCadre) {
        log.info("Inside updateCadre methode of CadreService");
        return cadreRepository.findById(id)
                .map(cadre -> {
                    cadre.setNom(newCadre.getNom());
                    cadre.setPrenom(newCadre.getPrenom());
                    cadre.setDate_naissance(newCadre.getDate_naissance());
                    cadre.setPoste(newCadre.getPoste());
                    cadre.setSexe(newCadre.getSexe());
                    cadre.setEmail(newCadre.getEmail());
                    return cadreRepository.save(cadre);
                }).get();
    }

    public Long deleteCadre(Long id) {
        log.info("Inside deleteCadre methode of CadreService");
        cadreRepository.deleteById(id);
        return id;
    }
}
