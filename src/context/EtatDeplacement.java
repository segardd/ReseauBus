package context;

public class EtatDeplacement implements EtatBus {

    @Override
    public void prochainArretDemande(ContextBus context) {
        // TODO Auto-generated method stub
        context.setEtatDuBus(new EtatArretImminent());
        
    }

    @Override
    public void ouvertureFermeturePorte(ContextBus context) {
        // TODO Auto-generated method stub
        System.out.println("Ouverture impossible en marche, ouvrez la fenêtre si vous avez trop chaud.");
        
    }

    @Override
    public void depart(ContextBus context) {
        // TODO Auto-generated method stub
        System.out.println("Vous voyez le paysage qui défile ? C'est qu'on est déjà en marche.");
        
    }

    @Override
    public void arret(ContextBus context) {
        // TODO Auto-generated method stub
        context.setEtatDuBus(new EtatArretImminent());
    }

}
