package modele;

import java.util.LinkedList;

public class Ligne {
    private int id=0;
    private String nom = "";
    private LinkedList<Arret> Arrets = null;
    private LinkedList<Bus> Bus = null;
    
    public Ligne(String nom) {
        this.nom= nom;
    }
    public Ligne(String nom, LinkedList<Arret> arrets) {
        this(nom);
        this.Arrets =  new LinkedList<Arret>();
        this.Bus = new LinkedList<Bus>();
        this.Arrets = arrets;
        
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LinkedList<Arret> getArrets() {
        return Arrets;
    }

    public void setArrets(LinkedList<Arret> arrets) {
        Arrets = arrets;
    }
    public void addArret (Arret arret) {
        this.Arrets.add(arret);
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public LinkedList<Bus> getBus() {
        return Bus;
    }
    public void setBus(LinkedList<Bus> bus) {
        Bus = bus;
    }
    public void addBus(Bus bus) {
        this.Bus.add(bus);
    }
    @Override
    public String toString() {
        return "Ligne [nom=" + nom + ", Arrets=" + Arrets + "]";
    }
}
