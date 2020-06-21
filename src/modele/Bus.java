package modele;

import java.util.Random;

import com.google.gson.annotations.Expose;

import context.ContextBus;
import context.EtatBus;
import events.ControlesDuBus;
import events.IEventsControleBus;
import events.IEventsDuBus;

public class Bus implements IEventsDuBus {
    private int idBus = 0;
    private String numero = "";
    private int ligne = 0;
    private int tmpDechargement = 0;

    private transient ControlesDuBus controleBus = new ControlesDuBus();

    private transient ContextBus monContext = new ContextBus(controleBus);
    
    public void setMonContext(ContextBus monContext) {
        this.monContext = monContext;
    }

    public ContextBus getMonContext() {
        return monContext;
    }


    public Bus(String numero) {
        this.numero = numero;
        tmpDechargement = (int) Math.random() * 5;
        controleBus = new ControlesDuBus();
        monContext = new ContextBus(controleBus);
    }

    public String getNumero() {
        return numero;
    }

    public ControlesDuBus getControleBus() {
        return controleBus;
    }


    public void setControleBus(ControlesDuBus controleBus) {
        this.controleBus = controleBus;
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

    public void Trajet() {

    }

    public void Arret() {

    }

    public void WhoRunTheBus(Ligne laLigne) {
        Runnable traitement = () -> {

            while (true) {
                for (int i = 0; i < laLigne.getArrets().size(); i++) {
                    monContext.depart();
                    System.out.println("bus numero " + this.numero + " en route");
                    try {
                        Thread.sleep(laLigne.getTrajets().get(i) * 1000);
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
        };
        new Thread(traitement).start();
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
