package simulation;

import java.time.Duration;
import java.util.LinkedList;

import daoFactory.DAOFactory;
import daoFactory.DAOFactory.SourcesDonnees;
import modele.Arret;
import modele.Bus;
import modele.Ligne;

public class Simulation {
    public static DAOFactory bdd = DAOFactory.getFactory(SourcesDonnees.JSON);
    public static void main(String[] args) {
        Bus bus1= new Bus("1");
        Bus bus2= new Bus("2");
        Bus bus3= new Bus("3");
        
        Arret arret1 = new Arret("arret 1","");
        Arret arret2 = new Arret("arret 2","");
        Arret arret3 = new Arret("arret3" , "");
        
        Ligne ligne1 = new Ligne("ligne n1");
        ligne1.addArret(arret1);
        ligne1.addArret(arret2);
        ligne1.addArret(arret3);
        LinkedList<Integer> delais = new LinkedList<Integer>();
        for (Arret arret : ligne1.getArrets()) {
            delais.add((int) (Math.random()*15));
        }
        
        ligne1.setTrajets(delais);
        
        ligne1.addBus(bus1);
        ligne1.addBus(bus2);
        ligne1.addBus(bus2);
        
        bdd.getLigneDAO().create(ligne1);
        
        LinkedList<Ligne> mesLignes = bdd.getLigneDAO().findall();
        mesLignes.get(0).toString();
        
        for (Ligne ligne : mesLignes) {
            for (Bus bus : ligne.getBus()) {
                bus.setLaLigne(ligne);
                bus.run();
            }
        }
        
        
        
    }
}
