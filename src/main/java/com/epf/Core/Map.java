package com.epf.Core;

public class Map {
    private int id;
    private int ligne;
    private int colonne;
    private String cheminImage;

    public Map() {}

    public Map(int ligne, int colonne, String cheminImage) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.cheminImage = cheminImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public String getCheminImage() {
        return cheminImage;
    }
    public void setCheminImage(String cheminImage) {
        if (cheminImage == null || cheminImage.isEmpty() || "/images/maps/default.png".equals(cheminImage)) {
            this.cheminImage = "/images/map/gazon.png";
        } else {
            this.cheminImage = cheminImage;}
    }

    @Override
    public String toString() {
        return "Map{" +
                "id=" + id +
                ", ligne=" + ligne +
                ", colonne=" + colonne +
                ", cheminImage='" + cheminImage + '\'' +
                '}';
    }
}

