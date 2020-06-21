package modele;

import java.util.LinkedList;

public class Arret {
    private int id= 0;
    private String nom = "";
    private int ligne= 0;
    private String positionGPS = "";
    
    //private LinkedList<Ligne> lesLignes= new LinkedList<Ligne>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPositionGPS() {
        return positionGPS;
    }

    public void setPositionGPS(String positionGPS) {
        this.positionGPS = positionGPS;
    }

    public Arret(String nom, String positionGPS) {
        super();
        this.nom = nom;
        this.positionGPS = positionGPS;
    }
    
    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Arret [nom=" + nom + ", positionGPS=" + positionGPS + "]";
    }

    
}
