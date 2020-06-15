package dao;

import java.util.LinkedList;

import modele.Reseau;

public class ReseauDAOMySQL extends DAO<Reseau>{
    
    private static ReseauDAOMySQL instance = null;

    private ReseauDAOMySQL() {

    }
    
    public ReseauDAOMySQL getInstance() {
        if (instance == null ) {
            instance = new ReseauDAOMySQL();
        }
        
        return instance;
    }

    @Override
    public Reseau find(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reseau create(Reseau obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Reseau update(Reseau obj) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(Reseau obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void saveall(LinkedList<Reseau> obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public LinkedList<Reseau> findall() {
        // TODO Auto-generated method stub
        return null;
    }

   
}
