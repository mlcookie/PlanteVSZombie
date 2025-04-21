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



    public double getAttaqueParSecondeZombie() {
        return attaqueParSecondeZombie;
    }

    public int getIdZombie() {
        return idZombie;
    }

    public double getVitesseDeDeplacement() {
        return vitesseDeDeplacement;
    }

    public int getPointDeVieZombie() {
        return pointDeVieZombie;
    }

    public int getDegatParSeconde() {
        return degatParSeconde;
    }

    public String getNomZombie() {
        return nomZombie;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public int getIdMap() {
        return idMap;
    }

    public void setAttaqueParSecondeZombie(double attaqueParSecondeZombie) {
        this.attaqueParSecondeZombie = attaqueParSecondeZombie;
    }

    public void setDegatParSeconde(int degatParSeconde) {
        this.degatParSeconde = degatParSeconde;
    }

    public void setIdZombie(int idZombie) {
        this.idZombie = idZombie;
    }

    public void setNomZombie(String nomZombie) {
        this.nomZombie = nomZombie;
    }

    public void setPointDeVieZombie(int pointDeVieZombie) {
        this.pointDeVieZombie = pointDeVieZombie;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }

    public void setVitesseDeDeplacement(double vitesseDeDeplacement) {
        this.vitesseDeDeplacement = vitesseDeDeplacement;
    }

}

