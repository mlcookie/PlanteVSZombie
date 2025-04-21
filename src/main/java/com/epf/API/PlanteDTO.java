package com.epf.API;

import com.epf.Core.Plante;

public class PlanteDTO {
    private int id;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private int cout;
    private double soleilParSeconde;
    private Plante.Effet effet;
    private String cheminImage;

    public PlanteDTO(Plante plante) {
        this.id = plante.getId();
        this.nom = plante.getNom();
        this.pointDeVie = plante.getPointDeVie();
        this.attaqueParSeconde = plante.getAttaqueParSeconde();
        this.degatAttaque = plante.getDegatAttaque();
        this.cout = plante.getCout();
        this.soleilParSeconde = plante.getSoleilParSeconde();
        this.effet = plante.getEffet();
        this.cheminImage = plante.getCheminImage();
    }

    public Plante toEntity() {
        return new Plante(nom, pointDeVie, attaqueParSeconde, degatAttaque, cout, soleilParSeconde, effet, cheminImage);
    }




    public String getCheminImage() {
        return cheminImage;
    }

    public int getId() {
        return id;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public String getNom() {
        return nom;
    }

    public double getAttaqueParSeconde() {
        return attaqueParSeconde;
    }

    public double getSoleilParSeconde() {
        return soleilParSeconde;
    }

    public Plante.Effet getEffet() {
        return effet;
    }

    public int getCout() {
        return cout;
    }

    public int getDegatAttaque() {
        return degatAttaque;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAttaqueParSeconde(double attaqueParSeconde) {
        this.attaqueParSeconde = attaqueParSeconde;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public void setDegatAttaque(int degatAttaque) {
        this.degatAttaque = degatAttaque;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void setEffet(Plante.Effet effet) {
        this.effet = effet;
    }

    public void setSoleilParSeconde(double soleilParSeconde) {
        this.soleilParSeconde = soleilParSeconde;
    }

}
