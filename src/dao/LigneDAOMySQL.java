package dao;

import java.sql.ResultSet;
import java.util.LinkedList;

import datasourceManagement.MySQLManager;
import modele.Ligne;
import modele.Ligne;

public class LigneDAOMySQL extends DAO<Ligne>{
    
    private static LigneDAOMySQL instance = null;

    private LigneDAOMySQL() {

    }
    
    public static LigneDAOMySQL getInstance() {
        if (instance == null ) {
            instance = new LigneDAOMySQL();
        }
        
        return instance;
    }

    public synchronized Ligne create(Ligne obj) {
        String req = "INSERT INTO ligne (ligneNom) "
                + "VALUES('"+obj.getNom()+"')";
        obj.setId(MySQLManager.getInstance().setData(req));
        return obj;
    }
    
    
    public Ligne find(long id) {
 
        String req = "SELECT * From ligne where "+ id;
        
        ResultSet result = MySQLManager.getInstance().getData(req);
        Ligne ligne = null;
        try {
            if (result.next()) {
            ligne = new Ligne(result.getString("ligneNom"));
            ligne.setId(result.getInt("ligneid"));
            
           /* String req2 ="SELECT * FROM operation where cleLigne = "+ligne.getCleLigne();
            
            ResultSet result2 = MySQLManager.getInstance().getData(req2);
            
            try{
                while (result2.next()) {
                   //System.out.println(result2.);
                    ligne.addOperation(result2.getString("intitule"),result2.getString("dateOperation"),result2.getFloat("montant"));                  
                }
            }
            catch(Exception e){
                System.out.println(e.toString());
                System.out.println("pas operations");
            }*/
        }
        }
        catch(Exception e){
            System.out.println(e.toString());
            System.out.println("pas ligne");
        }
        
        return ligne;  

    }
    
    public LinkedList<Ligne> findall() {
         
        String req = "SELECT * From ligne";
        LinkedList<Ligne> lignes = new LinkedList<Ligne>();
        ResultSet result = MySQLManager.getInstance().getData(req);
        Ligne ligne = null;
        try {
            while(result.next()) {
                ligne = new Ligne(result.getString("ligneNom"));
                ligne.setId(result.getInt("ligneid"));
                
                /*String req2 = "SELECT * FROM operation Where cleLigne = "+ligne.getCleLigne();
                
                ResultSet result2 = MySQLManager.getInstance().getData(req2);
                
                lignes.add(ligne);
                
                try{
                    while (result2.next()) {
                        ligne.addOperation(result2.getString("intitule"),result2.getString("dateOperation"),result2.getFloat("montant"));                  
                    }
                    ligne.toString();
                }
                catch(Exception e){
                    System.out.println(e.toString());
                    System.out.println("pas operations");
                }*/
            }       
        }
        catch(Exception e){
            System.out.println(e.toString());
            System.out.println("pas ligne");
        }
        
        return lignes; 

    }
    
    
    public Ligne update(Ligne obj) {
        String req = String.format("Update * From ligne values(%s) Where %i", obj.getNom(),obj.getId());
        
        MySQLManager.getInstance().setData(req);
        return obj;
        
    }


    public void delete(Ligne obj) {
        String req = String.format("DELETE From ligne Where %i", obj.getId());
    }
    
    public void saveall(LinkedList<Ligne> obj) {
        
        for (Ligne ligne : obj) {
            if (ligne.getId()==0) {
                ligne = create(ligne);    
            }else {
                ligne = update(ligne);
            }
        }
        
    }
   
    
    
}
