package modele;

import java.util.LinkedList;

public class Arret {
    private int id= 0;
    private String nom = "";
    private int ligne= 0;
    private int[] positionGPS = new int[2];
    
    //private LinkedList<Ligne> lesLignes= new LinkedList<Ligne>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int[] getPositionGPS() {
        return this.positionGPS;
    }
    
    public int getPositionGPSX() {
        return this.positionGPS[0];
    }
    
    public int getPositionGPSY() {
        return this.positionGPS[1];
    }

    public void setPositionGPS(int X, int Y) {
        this.positionGPS[0] = X;
        this.positionGPS[1] = Y;
    }
    
    public void setPositionGPSX(int X) {
        this.positionGPS[0] = X;
    }
    
    public void setPositionGPSY(int Y) {
        this.positionGPS[0] = Y;
    }
    
    

    public Arret(String nom, int positionGPSX, int positionGPSY) {
        super();
        this.nom = nom;
        this.positionGPS[0] = positionGPSX;
        this.positionGPS[1] = positionGPSY;
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
