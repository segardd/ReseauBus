package dao;

import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import datasourceManagement.JsonManager;
import modele.Arret;
import modele.Ligne;

public class ArretDAOJson extends DAO<Arret> {
    private static ArretDAOJson instance;
    private final GsonBuilder builder = new GsonBuilder();
    private final Gson gson = builder.create();
    private LinkedList<Ligne> lignes = JsonManager.getInstance().getData();
    private int maxId;
    
    private ArretDAOJson() {
        maxId = 0;
        for (Ligne ligne : lignes) {
            for (Arret arret : ligne.getArrets()) {
                if (arret.getId() > maxId) {
                    maxId = arret.getId();
                }
            }
        }
        
    }
    
    public static ArretDAOJson getInstance() {
        if (instance == null)
            instance = new ArretDAOJson();
        return instance;
    }

    @Override
    public Arret find(long id) {
        Arret arret = null;
        
        for (Ligne cmpt : lignes) {
            for (Arret art : cmpt.getArrets()) {
                if(art.getId() == id) {
                    arret = art;
                }
            }
        }
        
        return arret;
    }

    @Override
    public Arret create(Arret obj) {
        obj.setId(++maxId);
        Ligne ligne = null;
        
        for (Ligne cmpt : lignes) {
            if(cmpt.getId() == obj.getId()) {
                ligne = cmpt;
            }
        }
        ligne.getArrets().add(obj);
        
        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();
        

        for (Ligne cmpt : lignes) {
            if(cmpt.getId() == obj.getId()) {
                ligne = cmpt;
            }
        }
        return ligne.getArrets().getLast();
    }

    @Override
    public Arret update(Arret obj) {
        int id = obj.getId();
        
        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();
        return find(id);
    }

    @Override
    public void delete(Arret obj) {
        Ligne ligne = null;
        
        for (Ligne cmpt : lignes) {
            if(cmpt.getId() == obj.getId()) {
                ligne = cmpt;
            }
        }
        ligne.getArrets().remove(obj);
        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();
        
    }

    @Override
    public void saveall(LinkedList<Arret> obj) {
        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();
        
    }

    @Override
    public LinkedList<Arret> findall() {
        LinkedList<Arret> arrets = new LinkedList<Arret>();
        
        for (Ligne ligne : lignes) {
            for (Arret arret : ligne.getArrets()) {
                arrets.add(arret);
            }
        }
        return arrets;
    }

   /* @Override
    public LinkedList<Arret> findByName(String obj) {
        LinkedList<Arret> arrets = new LinkedList<Arret>();
        
        for (Ligne cmpt : lignes) {
            for (Arret art : cmpt.getArrets()) {
                if(art.getIntitule() == obj) {
                    arrets.add(art);
                }
            }
        }
        
        return arrets;
    }*/

}
