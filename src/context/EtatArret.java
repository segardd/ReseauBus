package context;

public class EtatArret implements EtatBus {

    private boolean demandeArret;
    public EtatBus etatPrecedent;
    
    public EtatArret() {
        // TODO Auto-generated constructor stub
        this.demandeArret = false;
    }
    
    @Override
    public void prochainArretDemande(ContextBus context) {
        // TODO Auto-generated method stub
        System.out.println("Attendre que le bus affiche l'arr�t suivant");
        
    }

    @Override
    public void ouvertureFermeturePorte(ContextBus context) {
        // TODO Auto-generated method stub
        context.getControleDuBus().ouvrirPortes();
        
    }

    @Override
    public void depart(ContextBus context) {
        // TODO Auto-generated method stub
        context.getControleDuBus().fermerPortes();
        context.getControleDuBus().demarrerBus();
    }

    @Override
    public void arret(ContextBus context) {
        // TODO Auto-generated method stub
        //context.getControleDuBus().stopperBus(); normalement d�j� � l'arr�t
        System.out.println("frein � main et point mort d�j� enclench� chef !");
        
    }

}
