package context;

import events.ControlesDuBus;
import events.IEventsControleBus;
import events.IEventsDuBus;

public class ContextBus implements IEventsDuBus {
    private transient EtatBus etatDuBus= new EtatArret();
    private IEventsControleBus controleDuBus = new ControlesDuBus();
    
    public ContextBus(IEventsControleBus controleBus) {
        this.controleDuBus = controleBus;
    }
    
    public EtatBus getEtatDuBus() {
        return etatDuBus;
    }

    public void setEtatDuBus(EtatBus etatDuBus) {
        this.etatDuBus = etatDuBus;
    }

    public IEventsControleBus getControleDuBus() {
        return controleDuBus;
    }

    public void setControleDuBus(IEventsControleBus controleDuBus) {
        this.controleDuBus = controleDuBus;
    }

    @Override
    public void prochainArretDemande() {
        // TODO Auto-generated method stub
        etatDuBus.prochainArretDemande(this);
        
    }

    @Override
    public void ouvertureFermeturePorte() {
        // TODO Auto-generated method stub
        etatDuBus.ouvertureFermeturePorte(this);
        
    }

    @Override
    public void arret() {
        // TODO Auto-generated method stub
        etatDuBus.arret(this);
    }

    @Override
    public void depart() {
        // TODO Auto-generated method stub
        etatDuBus.depart(this);
    }





}
