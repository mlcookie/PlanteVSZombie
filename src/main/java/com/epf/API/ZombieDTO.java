package com.epf.API;

import com.epf.Core.Zombies;

public class ZombieDTO {
    private int idZombie;
    private String nomZombie;
    private int pointDeVieZombie;
    private double attaqueParSecondeZombie;
    private int degatParSeconde;
    private double vitesseDeDeplacement;
    private String cheminImage;
    private int idMap;

    public ZombieDTO(Zombies zombie) {
        this.idZombie = zombie.getIdZombie();
        this.nomZombie = zombie.getNomZombie();
        this.pointDeVieZombie = zombie.getPointDeVieZombie();
        this.attaqueParSecondeZombie = zombie.getAttaqueParSecondeZombie();
        this.degatParSeconde = zombie.getDegatParSeconde();
        this.vitesseDeDeplacement = zombie.getVitesseDeDeplacement();
        this.cheminImage = zombie.getCheminImage();
        this.idMap = zombie.getIdMap();
    }

    public Zombies toEntity() {
        return new Zombies(idZombie, nomZombie, pointDeVieZombie, attaqueParSecondeZombie, degatParSeconde, vitesseDeDeplacement, cheminImage, idMap);
    }

    // Getters et Setters...
}

