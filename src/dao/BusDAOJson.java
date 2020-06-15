package dao;

import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import datasourceManagement.JsonManager;
import modele.Bus;
import modele.Ligne;

public class BusDAOJson extends DAO<Bus> {
    private static BusDAOJson instance;
    private final GsonBuilder builder = new GsonBuilder();
    private final Gson gson = builder.create();
    private LinkedList<Ligne> lignes = JsonManager.getInstance().getData();
    private int maxId;
    
    private BusDAOJson() {
        maxId = 0;
        for (Ligne ligne : lignes) {
            for (Bus Bus : ligne.getBus()) {
                if (Bus.getId() > maxId) {
                    maxId = Bus.getId();
                }
            }
        }
        
    }
    
    public static BusDAOJson getInstance() {
        if (instance == null)
            instance = new BusDAOJson();
        return instance;
    }

    @Override
    public Bus find(long id) {
        Bus Bus = null;
        
        for (Ligne cmpt : lignes) {
            for (Bus monBus : cmpt.getBus()) {
                if(monBus.getId() == id) {
                    Bus = monBus;
                }
            }
        }
        
        return Bus;
    }

    @Override
    public Bus create(Bus obj) {
        obj.setId(++maxId);
        Ligne ligne = null;
        
        for (Ligne cmpt : lignes) {
            if(cmpt.getId() == obj.getId()) {
                ligne = cmpt;
            }
        }
        ligne.getBus().add(obj);
        
        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();
        

        for (Ligne cmpt : lignes) {
            if(cmpt.getId() == obj.getId()) {
                ligne = cmpt;
            }
        }
        return ligne.getBus().getLast();
    }

    @Override
    public Bus update(Bus obj) {
        int id = obj.getId();
        
        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();
        return find(id);
    }

    @Override
    public void delete(Bus obj) {
        Ligne ligne = null;
        
        for (Ligne cmpt : lignes) {
            if(cmpt.getId() == obj.getId()) {
                ligne = cmpt;
            }
        }
        ligne.getBus().remove(obj);
        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();
        
    }

    @Override
    public void saveall(LinkedList<Bus> obj) {
        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();
        
    }

    @Override
    public LinkedList<Bus> findall() {
        LinkedList<Bus> Buss = new LinkedList<Bus>();
        
        for (Ligne ligne : lignes) {
            for (Bus Bus : ligne.getBus()) {
                Buss.add(Bus);
            }
        }
        return Buss;
    }

   /* @Override
    public LinkedList<Bus> findByName(String obj) {
        LinkedList<Bus> Buss = new LinkedList<Bus>();
        
        for (Ligne cmpt : lignes) {
            for (Bus monBus : cmpt.getBus()) {
                if(monBus.getIntitule() == obj) {
                    Buss.add(monBus);
                }
            }
        }
        
        return Buss;
    }*/

}
