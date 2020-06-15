package modele;

import java.util.Random;

import context.ContextBus;
import context.EtatBus;
import events.ControlesDuBus;
import events.IEventsControleBus;
import events.IEventsDuBus;

public class Bus implements IEventsDuBus {
    private int id = 0;
    private String numero="";
    private int ligne = 0;
    private int tmpDechargement = 0;
    
    private ContextBus monContext;
    private ControlesDuBus controleBus;
    
    public Bus (String numero) {
        this.numero= numero;
        tmpDechargement= (int) Math.random()*5;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void Trajet() {
        
    }

    
    public void Arret() {
        
    }

    @Override
    public String toString() {
        return "Bus [numero=" + numero + "]";
    }

    @Override
    public void prochainArretDemande() {
        // TODO Auto-generated method stub
        System.out.println("quelqu'un veut sortir au prochain arrêt");
        monContext.prochainArretDemande();
        
    }

    @Override
    public void ouvertureFermeturePorte() {
        // TODO Auto-generated method stub
        monContext.ouvertureFermeturePorte();
        
        
        
    }

    @Override
    public void arret() {
        // TODO Auto-generated method stub
        monContext.arret();
        
    }

    @Override
    public void depart() {
        // TODO Auto-generated method stub
        monContext.depart();
        
    }




    
    
}
