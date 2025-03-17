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

    // Getters et Setters...


}
