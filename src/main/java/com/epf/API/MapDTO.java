package com.epf.API;
import com.epf.Core.Map;

public class MapDTO {
    private int id_map;
    private int ligne;
    private int colonne;
    private String chemin_image;

    public MapDTO(Map map) {
        this.id_map = map.getId();
        this.ligne = map.getLigne();
        this.colonne = map.getColonne();
        this.chemin_image = map.getCheminImage();
    }

    public MapDTO() {
        // constructeur vide pour la désérialisation
    }


    public Map toEntity() {
        Map map = new Map();
        map.setId(id_map);
        map.setLigne(ligne);
        map.setColonne(colonne);
        map.setCheminImage(chemin_image);
        return map;
    }




    public int getColonne() {
        return colonne;
    }

    public int getLigne() {
        return ligne;
    }



    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setChemin_image(String chemin_image) {
        this.chemin_image = chemin_image;
    }

    public void setId_map(int id_map) {
        this.id_map = id_map;
    }


    public int getId_map() {
        return id_map;
    }

    public String getChemin_image() {
        return chemin_image;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

}
