package modele;


import java.util.Random;

import context.ContextBus;
import context.EtatBus;
import events.ControlesDuBus;
import events.IEventsControleBus;
import events.IEventsDuBus;

public class Bus extends Thread implements IEventsDuBus{
    private int idBus = 0;
    private String numero="";
    private int ligne = 0;
    private int tmpDechargement = 0;
    private Ligne laLigne= null;
    
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
    
    

    public long getId() {
        return idBus;
    }

    public void setId(int id) {
        this.idBus = id;
    }
    
    public Ligne getLaLigne() {
        return laLigne;
    }

    public void setLaLigne(Ligne laLigne) {
        this.laLigne = laLigne;
    }

    public void Trajet() {
        
    }

    
    public void Arret() {
        
    }
    
    @Override
    public void run() {
      while (true) {
          for(int i=0; i< this.laLigne.getArrets().size(); i++) {
              monContext.depart();
              System.out.println("bus numero "+this.idBus+" en route");
              try {
                Thread.sleep(this.laLigne.getTrajets().get(i) * 1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
              monContext.prochainArretDemande();
              try {
                  Thread.sleep(2 * 1000);
              } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
              monContext.arret();
              monContext.ouvertureFermeturePorte();
              try {
                  Thread.sleep(this.tmpDechargement);
              } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
          }
      }
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
