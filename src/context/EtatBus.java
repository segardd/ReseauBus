package context;

import events.IEventsDuBus;

public abstract class EtatBus {
    
    public EtatBus etatPrecedent;
  
    public abstract void prochainArretDemande(ContextBus context);


    public abstract void ouvertureFermeturePorte(ContextBus context);
    
    public abstract void depart(ContextBus context);
    
    public abstract void arret(ContextBus context);
    

}
