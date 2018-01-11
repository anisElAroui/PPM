/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.model;

/**
 *
 * @author anis
 */
public class Colis {
    
    private int id ;
    private String nom,lien ;
    private int quantite;

    public Colis() {
    }

    public Colis(String nom, String lien, int quantite) {
        this.nom = nom;
        this.lien = lien;
        this.quantite = quantite;
    }

    public Colis(int id, String nom, String lien, int quantite) {
        this.id = id;
        this.nom = nom;
        this.lien = lien;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
    
    
    
}
