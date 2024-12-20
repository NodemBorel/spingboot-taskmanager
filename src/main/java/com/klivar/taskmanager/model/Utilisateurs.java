package com.klivar.taskmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateurs")
public class Utilisateurs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
