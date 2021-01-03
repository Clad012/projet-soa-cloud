package com.projetsoacloud.etudiant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "absence")
public class Absence extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "annee_scolaire")
    private String anneeScolaire;

    @ManyToOne
    @JoinColumn(name="etudiant.id", nullable=false)
    private Etudiant etudiant;

    @Column(name = "enseignantId")
    private Long enseignantId;
}
