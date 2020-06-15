package dao;

import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import datasourceManagement.JsonManager;
import modele.Ligne;

public class LigneDAOJson extends DAO<Ligne> {
    private static LigneDAOJson instance;
    private final GsonBuilder builder = new GsonBuilder();
    private final Gson gson = builder.create();
    private LinkedList<Ligne> lignes = JsonManager.getInstance().getData();
    int maxId;

    private LigneDAOJson() {
        maxId = 0;
        for (Ligne ligne : lignes) {
            if (ligne.getId() > maxId) {
                maxId = ligne.getId();
            }
        }
    }

    public static LigneDAOJson getInstance() {
        if (instance == null)
            instance = new LigneDAOJson();
        return instance;
    }

    @Override
    public Ligne find(long id) {
        Ligne laLigne = null;
        for (Ligne ligne : lignes) {
            if (ligne.getId() == id) {
                laLigne = ligne;
            }
        }

        return laLigne;
    }

    @Override
    public Ligne create(Ligne obj) {
        obj.setId(++maxId);
        lignes.add(obj);

        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();
        return lignes.getLast();
    }

    @Override
    public Ligne update(Ligne obj) {
        int id = obj.getId();

        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();
        return find(id);
    }

    @Override
    public void delete(Ligne obj) {
        lignes.remove(obj);
        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();

    }

    @Override
    public void saveall(LinkedList<Ligne> obj) {
        // TODO Auto-generated method stub
        JsonManager.getInstance().setData(gson.toJson(lignes));
        lignes = JsonManager.getInstance().getData();     
    }

    @Override
    public LinkedList<Ligne> findall() {
        // TODO Auto-generated method stub
        return lignes;
    }

}
