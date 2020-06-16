package modele;

import java.time.Duration;
import java.util.LinkedList;

public class Ligne {
    private int id=0;
    private String nom = "";
    private LinkedList<Arret> Arrets = null;
    private LinkedList<Bus> Bus = null;
    private LinkedList<Duration> trajets;
    
    public Ligne(String nom) {
        this.nom= nom;
        this.trajets = new LinkedList<Duration>();
        this.Arrets =  new LinkedList<Arret>();
        this.Bus = new LinkedList<Bus>();
    }
    public Ligne(String nom, LinkedList<Arret> arrets) {
        this(nom);
        this.Arrets = arrets;
        
        
    }

    public LinkedList<Duration> getTrajets() {
        return trajets;
    }
    public void setTrajets(LinkedList<Duration> trajets) {
        this.trajets = trajets;
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
    
    public void AddDelais(Duration delais) {
        this.trajets.add(delais);
    }
    @Override
    public String toString() {
        return "Ligne [nom=" + nom + ", Arrets=" + Arrets + "]";
    }
}
