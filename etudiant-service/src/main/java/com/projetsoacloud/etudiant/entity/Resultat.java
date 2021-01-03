package com.projetsoacloud.etudiant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resultat")
public class Resultat extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "moyenne")
    private Long moyenne;

    @Column(name = "annee_scolaire")
    private String anneeScolaire;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="etudiant.id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Etudiant etudiant;
}
