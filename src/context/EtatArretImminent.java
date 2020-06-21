package context;

public class EtatArretImminent implements EtatBus {

    @Override
    public void prochainArretDemande(ContextBus context) {
        // TODO Auto-generated method stub
        System.out.println("déjà demandé");
        
    }

    @Override
    public void ouvertureFermeturePorte(ContextBus context) {
        // TODO Auto-generated method stub
        System.out.println("Veuillez attendre l'arret total du bus");
    }

    @Override
    public void depart(ContextBus context) {
        // TODO Auto-generated method stub
        
        
    }

    @Override
    public void arret(ContextBus context) {
        // TODO Auto-generated method stub
        context.getControleDuBus().stopperBus();
        context.setEtatDuBus(new EtatArret());
    }

}
