package com.projetsoacloud.etudiant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "etudiant")
public class Etudiant extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private Date date_naissance;

    @Column(name = "classe")
    private String classe;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "email")
    private String email;

    /*@OneToMany(mappedBy="etudiant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resultat> resultats;

    @OneToMany(mappedBy="etudiant", fetch = FetchType.LAZY)
    private List<Resultat> absences;*/
}
