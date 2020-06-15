package events;

public class ControlesDuBus implements IEventsControleBus{

    @Override
    public void ouvrirPortes() {
        // TODO Auto-generated method stub
        System.out.println("Portes ouvertes");
        
    }

    @Override
    public void fermerPortes() {
        // TODO Auto-generated method stub
        System.out.println("Portes fermées");
        
    }

    @Override
    public void stopperBus() {
        // TODO Auto-generated method stub
        System.out.println("Le Bus ralentit et freine jusqu'à se stopper à l'arrêt");
    }

    @Override
    public void demarrerBus() {
        // TODO Auto-generated method stub
        System.out.println("Le Bus se met en marche pour aller au prochain arrêt");
    }

}
