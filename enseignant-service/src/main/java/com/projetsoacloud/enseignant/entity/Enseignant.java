package com.projetsoacloud.enseignant.entity;

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
@Table(name = "enseignant")
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private String date_naissance;

    @Column(name = "grade")
    private String grade;

    @Column(name = "sexe")
    private String sexe;

    @Column(name = "email")
    private String email;
}
