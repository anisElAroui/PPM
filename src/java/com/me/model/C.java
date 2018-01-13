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
public class C {
    private int id, poids ;
    private String nom,destination,mp;

    public C() {
    }

    public C(int poids, String nom, String destination, String mp) {
        this.poids = poids;
        this.nom = nom;
        this.destination = destination;
        this.mp = mp;
    }

    public C(int id, int poids, String nom, String destination, String mp) {
        this.id = id;
        this.poids = poids;
        this.nom = nom;
        this.destination = destination;
        this.mp = mp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }
    
    

}
