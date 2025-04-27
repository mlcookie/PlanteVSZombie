package com.epf.Core;

public class Plante {
    private int id;
    private String nom;
    private int pointDeVie;
    private double attaqueParSeconde;
    private int degatAttaque;
    private int cout;
    private double soleilParSeconde;
    private Effet effet;
    private String cheminImage;

    public enum Effet {
        NORMAL("normal"),
        SLOW_LOW("slow low"),
        SLOW_MEDIUM("slow medium"),
        SLOW_STOP("slow stop");

        private final String value;

        Effet(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        public static Effet fromString(String text) {
            if (text == null) {
                throw new IllegalArgumentException("Effet cannot be null");
            }

            for (Effet effet : Effet.values()) {
                if (effet.value.equalsIgnoreCase(text)) {
                    return effet;
                }
            }

            throw new IllegalArgumentException("No enum constant for value: " + text);
        }


    }


    public Plante() {
        this.attaqueParSeconde = 0.00;
        this.degatAttaque = 0;
        this.soleilParSeconde = 0.00;
        this.effet = Effet.NORMAL;
    }


    public Plante(String nom, int pointDeVie, double attaqueParSeconde, int degatAttaque, int cout, double soleilParSeconde, Effet effet, String cheminImage) {
        this.nom = nom;
        this.pointDeVie = pointDeVie;
        this.attaqueParSeconde = attaqueParSeconde;
        this.degatAttaque = degatAttaque;
        this.cout = cout;
        this.soleilParSeconde = soleilParSeconde;
        this.effet = effet;
        this.cheminImage = cheminImage;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(int pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public double getAttaqueParSeconde() {
        return attaqueParSeconde;
    }

    public void setAttaqueParSeconde(double attaqueParSeconde) {
        this.attaqueParSeconde = attaqueParSeconde;
    }

    public int getDegatAttaque() {
        return degatAttaque;
    }

    public void setDegatAttaque(int degatAttaque) {
        this.degatAttaque = degatAttaque;
    }

    public int getCout() {
        return cout;
    }

    public void setCout(int cout) {
        this.cout = cout;
    }

    public double getSoleilParSeconde() {
        return soleilParSeconde;
    }

    public void setSoleilParSeconde(double soleilParSeconde) {
        this.soleilParSeconde = soleilParSeconde;
    }

    public Effet getEffet() {
        return effet;
    }

    public void setEffet(Effet effet) {
        this.effet = effet;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        if (cheminImage == null || cheminImage.isEmpty() || "/images/plantes/default.png".equals(cheminImage)) {
            this.cheminImage = "/images/plante/default.png";
        } else {
            this.cheminImage = cheminImage;
        }
    }

    @Override
    public String toString() {
        return "Plante{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pointDeVie=" + pointDeVie +
                ", attaqueParSeconde=" + attaqueParSeconde +
                ", degatAttaque=" + degatAttaque +
                ", cout=" + cout +
                ", soleilParSeconde=" + soleilParSeconde +
                ", effet=" + effet +
                ", cheminImage='" + cheminImage + '\'' +
                '}';
    }
}