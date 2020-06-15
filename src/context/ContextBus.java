package context;

import events.IEventsControleBus;
import events.IEventsDuBus;

public class ContextBus implements IEventsDuBus {
    private EtatBus etatDuBus;
    private IEventsControleBus controleDuBus;
    
    public ContextBus(IEventsControleBus controleBus) {
        this.controleDuBus = controleBus;
        this.etatDuBus = new EtatArret();
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
        
    }

    @Override
    public void ouvertureFermeturePorte() {
        // TODO Auto-generated method stub
        
    }



}
