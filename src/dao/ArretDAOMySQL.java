package dao;

import java.sql.ResultSet;
import java.util.LinkedList;

import datasourceManagement.MySQLManager;
import modele.Arret;
import modele.Arret;

public class ArretDAOMySQL extends DAO<Arret> {
    private static ArretDAOMySQL instance = null;

    private ArretDAOMySQL() {

    }

    public static ArretDAOMySQL getInstance() {
        if (instance == null) {
            instance = new ArretDAOMySQL();
        }

        return instance;
    }

    public synchronized Arret create(Arret obj) {
        String req = "INSERT INTO arret (arretNom, arretPositionGPS, arretLigne) "
                + "VALUES('"+obj.getNom()+"','"+obj.getPositionGPS()+", "+obj.getLigne()+"')";
        obj.setId(MySQLManager.getInstance().setData(req));
        return obj;
    }
    
    
    public Arret find(long id) {
        return null; // à défaire si implémentation 
        /*String req = "SELECT * From arret where "+ id;
        
        ResultSet result = MySQLManager.getInstance().getData(req);
        Arret arret = null;
        try {
            if (result.next()) {
            arret = new Arret(result.getString("arretNom"),result.getString("arretPositionGPS"));
            arret.setId(result.getInt("cleArret"));
            
           /* String req2 ="SELECT * FROM operation where cleArret = "+arret.getCleArret();
            
            ResultSet result2 = MySQLManager.getInstance().getData(req2);
            
            try{
                while (result2.next()) {
                   //System.out.println(result2.);
                    arret.addOperation(result2.getString("intitule"),result2.getString("dateOperation"),result2.getFloat("montant"));                  
                }
            }
            catch(Exception e){
                System.out.println(e.toString());
                System.out.println("pas operations");
            }*/
        /*}
        }
        catch(Exception e){
            System.out.println(e.toString());
            System.out.println("pas arret");
        }
        
        return arret;  */

    }
    
    public LinkedList<Arret> findall() {
         
        String req = "SELECT * From arret";
        LinkedList<Arret> arrets = new LinkedList<Arret>();
        ResultSet result = MySQLManager.getInstance().getData(req);
        Arret arret = null;
        try {
            while(result.next()) {
                arret = new Arret(result.getString("arretNumero"),
                        Integer.parseInt(result.getString("arretPositionGPS").split(",")[0]),
                        Integer.parseInt(result.getString("arretPositionGPS").split(",")[1]));
                arret.setId(result.getInt("arretid"));
                
                /*String req2 = "SELECT * FROM operation Where cleArret = "+arret.getCleArret();
                
                ResultSet result2 = MySQLManager.getInstance().getData(req2);
                
                arrets.add(arret);
                
                try{
                    while (result2.next()) {
                        arret.addOperation(result2.getString("intitule"),result2.getString("dateOperation"),result2.getFloat("montant"));                  
                    }
                    arret.toString();
                }
                catch(Exception e){
                    System.out.println(e.toString());
                    System.out.println("pas operations");
                }*/
            }       
        }
        catch(Exception e){
            System.out.println(e.toString());
            System.out.println("pas arret");
        }
        
        return arrets; 

    }
    
    
    public Arret update(Arret obj) {
        String req = String.format("Update * From arret values(%s,%s) Where %i", obj.getNom(),obj.getPositionGPS(),obj.getId());
        
        MySQLManager.getInstance().setData(req);
        return obj;
        
    }


    public void delete(Arret obj) {
        String req = String.format("DELETE From arret Where %i", obj.getId());
    }
    
    public void saveall(LinkedList<Arret> obj) {
        
        for (Arret arret : obj) {
            if (arret.getId()==0) {
                arret = create(arret);    
            }else {
                arret = update(arret);
            }
        }
        
    }
}
