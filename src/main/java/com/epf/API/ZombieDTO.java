package com.epf.API;

import com.epf.Core.Zombies;

public class ZombieDTO {

    private int id_zombie;
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde;
    private int degat_attaque;
    private double vitesse_de_deplacement;
    private String chemin_image;
    private Integer id_map; // `Integer` si tu veux gérer `null`



    public ZombieDTO(Zombies zombie) {

        this.id_zombie = zombie.getIdZombie();
        this.nom = zombie.getNomZombie();
        this.point_de_vie = zombie.getPointDeVieZombie();
        this.attaque_par_seconde = zombie.getAttaqueParSecondeZombie();
        this.degat_attaque = zombie.getDegatParSeconde();
        this.vitesse_de_deplacement = zombie.getVitesseDeDeplacement();
        this.chemin_image = zombie.getCheminImage();
        this.id_map = zombie.getIdMap();
    }

    public ZombieDTO() {
        // constructeur vide pour la désérialisation
    }

    public Zombies toEntity() {
        return new Zombies(id_zombie, nom, point_de_vie, attaque_par_seconde, degat_attaque, vitesse_de_deplacement, chemin_image, id_map);
    }


    public String getNom() {
        return nom;
    }

    public int getId_zombie() {
        return id_zombie;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public double getAttaque_par_seconde() {
        return attaque_par_seconde;
    }

    public double getVitesse_de_deplacement() {
        return vitesse_de_deplacement;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public Integer getId_map() {
        return id_map;
    }


    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId_zombie(int id_zombie) {
        this.id_zombie = id_zombie;
    }

    public void setAttaque_par_seconde(double attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public void setId_map(Integer id_map) {
        this.id_map = id_map;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public void setVitesse_de_deplacement(double vitesse_de_deplacement) {
        this.vitesse_de_deplacement = vitesse_de_deplacement;
    }


}

