package com.epf.API;

import com.epf.Core.Plante;

public class PlanteDTO {
    private int id_plante;
    private String nom;
    private int point_de_vie;
    private double attaque_par_seconde;
    private int degat_attaque;
    private int cout;
    private double soleil_par_seconde;
    private String effet; // attention ici : transforme ton enum en String
    private String chemin_image;

    public PlanteDTO(Plante plante) {
        this.id_plante = plante.getId();
        this.nom = plante.getNom();
        this.point_de_vie = plante.getPointDeVie();
        this.attaque_par_seconde = plante.getAttaqueParSeconde();
        this.degat_attaque = plante.getDegatAttaque();
        this.cout = plante.getCout();
        this.soleil_par_seconde = plante.getSoleilParSeconde();
        this.effet = String.valueOf(plante.getEffet());
        this.chemin_image = plante.getCheminImage();
    }

    public Plante toEntity() {
        return new Plante(nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image);
    }

    public int getPoint_de_vie() {
        return point_de_vie;
    }

    public String getNom() {
        return nom;
    }

    public double getAttaque_par_seconde() {
        return attaque_par_seconde;
    }

    public int getDegat_attaque() {
        return degat_attaque;
    }

    public int getId_plante() {
        return id_plante;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public int getCout() {
        return cout;
    }

    public double getSoleil_par_seconde() {
        return soleil_par_seconde;
    }

    public String getEffet() {
        return effet;
    }

    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }

    public void setAttaque_par_seconde(double attaque_par_seconde) {
        this.attaque_par_seconde = attaque_par_seconde;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDegat_attaque(int degat_attaque) {
        this.degat_attaque = degat_attaque;
    }

    public void setId_plante(int id_plante) {
        this.id_plante = id_plante;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public void setEffet(String effet) {
        this.effet = effet;
    }

    public void setSoleil_par_seconde(double soleil_par_seconde) {
        this.soleil_par_seconde = soleil_par_seconde;
    }


}
