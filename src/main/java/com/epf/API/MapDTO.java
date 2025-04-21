package com.epf.API;
import com.epf.Core.Map;

public class MapDTO {
    private int id;
    private int ligne;
    private int colonne;
    private String cheminImage;

    public MapDTO(Map map) {
        this.id = map.getId();
        this.ligne = map.getLigne();
        this.colonne = map.getColonne();
        this.cheminImage = map.getCheminImage();
    }

    public Map toEntity() {
        Map map = new Map();
        map.setId(id);
        map.setLigne(ligne);
        map.setColonne(colonne);
        map.setCheminImage(cheminImage);
        return map;
    }




    public int getColonne() {
        return colonne;
    }

    public int getId() {
        return id;
    }

    public int getLigne() {
        return ligne;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }


}
