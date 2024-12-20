package com.klivar.taskmanager.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "taches")
public class Taches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre", nullable = false, length = 200)
    private String titre;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "date_creation", nullable = false, updatable = false)
    private LocalDateTime dateCreation = LocalDateTime.now();

    @Column(name = "date_echeance")
    private LocalDate dateEcheance;

    @Column(name = "priorite", nullable = false)
    private Integer priorite;

    @ManyToOne
    @JoinColumn(name = "statut_id", referencedColumnName = "id", nullable = false)
    private Statuts statutId;

    @ManyToOne
    @JoinColumn(name = "categorie_id", referencedColumnName = "id", nullable = false)
    private Categories categorieId;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", referencedColumnName = "id", nullable = false)
    private Utilisateurs utilisateurId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDate getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(LocalDate dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Integer getPriorite() {
        return priorite;
    }

    public void setPriorite(Integer priorite) {
        this.priorite = priorite;
    }

    public Statuts getStatutId() {
        return statutId;
    }

    public void setStatutId(Statuts statutId) {
        this.statutId = statutId;
    }

    public Categories getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Categories categorieId) {
        this.categorieId = categorieId;
    }

    public Utilisateurs getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Utilisateurs utilisateurId) {
        this.utilisateurId = utilisateurId;
    }
}
