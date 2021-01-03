package com.projetsoacloud.etudiant.service;

import com.projetsoacloud.etudiant.entity.Resultat;
import com.projetsoacloud.etudiant.entity.Statistique;
import com.projetsoacloud.etudiant.repository.EtudiantRepository;
import com.projetsoacloud.etudiant.repository.ResultatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ResultatService {

    @Autowired
    private ResultatRepository resultatRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    public Resultat saveResultat(Long etudiantId,Resultat resultat) {
        log.info("Inside saveResultat methode of ResultatService");
        if(resultatRepository.existsByEtudiantIdAndAnneeScolaire(etudiantId, resultat.getAnneeScolaire()))
            return updateResultat(etudiantId,resultat);
        else
            return etudiantRepository.findById(etudiantId)
                    .map(etudiant -> {
                        resultat.setEtudiant(etudiant);
                        return resultatRepository.save(resultat);
                    }).get();
    }

    public List<Resultat> findResultatsByEtudiantId(Long etudiantId) {
        log.info("Inside findResultatsByEtudiantId methode of ResultatService");
        return resultatRepository.findByEtudiantId(etudiantId);
    }

    public Resultat updateResultat(Long id, Resultat newResultat) {
        log.info("Inside updateResultat methode of ResultatService");
        return resultatRepository.findById(id)
                .map(resultat -> {
                    resultat.setMoyenne(newResultat.getMoyenne());
                    resultat.setAnneeScolaire(newResultat.getAnneeScolaire());
                    return resultatRepository.save(resultat);
                }).get();
    }

    public Long deleteResultat(Long id) {
        log.info("Inside deleteResultat methode of ResultatService");
        resultatRepository.deleteById(id);
        return id;
    }

    public List<Statistique> countAdmisByClasse(String anneeScolaire){
        log.info("Inside countAdmisByClasse methode of ResultatService");
        List<Statistique> stats = resultatRepository.countAdmisByClasse(anneeScolaire);
        List<Statistique> totals = resultatRepository.countAllByClasse(anneeScolaire);

        return calculTaux(stats, totals);
    }

    public List<Statistique> countAdmisBySexe(String anneeScolaire) {
        log.info("Inside countAdmisBySexe methode of ResultatService");
        List<Statistique> stats = resultatRepository.countAdmisBySexe(anneeScolaire);
        List<Statistique> totals = resultatRepository.countAllBySexe(anneeScolaire);

        return calculTaux(stats, totals);
    }

    public List<Statistique> countAdmisByAnneeScolaire() {
        log.info("Inside countAdmisByAnneScolaire methode of ResultatService");
        List<Statistique> stats = resultatRepository.countAdmisByAnneScolaire();
        List<Statistique> totals = resultatRepository.countAllByAnneeScolaire();

        return calculTaux(stats, totals);
    }

    public List<Statistique> calculTaux(List<Statistique> stats, List<Statistique> totals){
        for (int i = 0; i < stats.size(); i++) {
            Statistique stat = stats.get(i);
            stat.setTaux((double)stat.getValeur()/totals.get(i).getValeur());
        }

        return stats;
    }

    /*public List<Statistique> topresultats(String anneeScolaire) {

        return resultatRepository.topresultats(anneeScolaire);
    }*/
}
