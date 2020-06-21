package context;

import events.IEventsDuBus;

public interface EtatBus {
    
    
  
    public abstract void prochainArretDemande(ContextBus context);


    public abstract void ouvertureFermeturePorte(ContextBus context);
    
    public abstract void depart(ContextBus context);
    
    public abstract void arret(ContextBus context);
    

}
