package com.epf.Core;

public class Zombies {
    private int idZombie;
    private String nomZombie;
    private int pointDeVieZombie;
    private double attaqueParSecondeZombie;
    private int degatParSeconde;
    private double vitesseDeDeplacement;
    private String cheminImage;
    private int idMap;

    public Zombies(int idZombie, String nomZombie, int pointDeVieZombie, double attaqueParSecondeZombie, int degatParSeconde, double vitesseDeDeplacement, String cheminImage, int idMap){
        this.idZombie = idZombie;
        this.nomZombie = nomZombie;
        this.pointDeVieZombie = pointDeVieZombie;
        this.attaqueParSecondeZombie = attaqueParSecondeZombie;
        this.degatParSeconde=degatParSeconde;
        this.vitesseDeDeplacement = vitesseDeDeplacement;
        this.cheminImage =cheminImage;
        this.idMap = idMap;
    }

   //public Zombies() {
    //}
    public int getIdZombie() {
        return idZombie;
    }

    public String getNomZombie() {
        return nomZombie;
    }

    public int getPointDeVieZombie() {
        return pointDeVieZombie;
    }

    public double getAttaqueParSecondeZombie() {
        return attaqueParSecondeZombie;
    }

    public int getDegatParSeconde() {
        return degatParSeconde;
    }

    public double getVitesseDeDeplacement() {
        return vitesseDeDeplacement;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public int getIdMap() {
        return idMap;
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

    public void setAttaqueParSecondeZombie(double attaqueParSecondeZombie) {
        this.attaqueParSecondeZombie = attaqueParSecondeZombie;
    }

    public void setCheminImage(String cheminImage) {
        if (cheminImage == null || cheminImage.isEmpty() || "/images/zombies/default.png".equals(cheminImage)) {
            this.cheminImage = "/images/zombie/default.png";
        } else {
            this.cheminImage = cheminImage;
        }
    }

    public void setDegatParSeconde(int degatParSeconde) {
        this.degatParSeconde = degatParSeconde;
    }

    public void setIdMap(int idMap) {
        this.idMap = idMap;
    }

    public void setVitesseDeDeplacement(double vitesseDeDeplacement) {
        this.vitesseDeDeplacement = vitesseDeDeplacement;
    }

    @Override
    public String toString() {
        return "Zombies{" +
                "idZombie=" + idZombie +
                ", nomZombie='" + nomZombie + '\'' +
                ", pointDeVieZombie=" + pointDeVieZombie +
                ", attaqueParSecondeZombie=" + attaqueParSecondeZombie +
                ", degatParSeconde=" + degatParSeconde +
                ", vitesseDeDeplacement=" + vitesseDeDeplacement +
                ", cheminImage='" + cheminImage + '\'' +
                ", idMap=" + idMap +
                '}';
    }
}

