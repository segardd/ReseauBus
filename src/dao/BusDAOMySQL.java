package dao;

import java.sql.ResultSet;
import java.util.LinkedList;

import datasourceManagement.MySQLManager;
import modele.Bus;
import modele.Bus;

public class BusDAOMySQL extends DAO<Bus>{
    
    private static BusDAOMySQL instance = null;
    
    private static MySQLManager base = MySQLManager.getInstance();

    private BusDAOMySQL() {

    }
    
    public static BusDAOMySQL getInstance() {
        if (instance == null ) {
            instance = new BusDAOMySQL();
        }
        
        return instance;
    }

    public synchronized Bus create(Bus obj) {
        String req = "INSERT INTO bus (busNumero) "
                + "VALUES('"+obj.getNumero()+"')";
        obj.setId(MySQLManager.getInstance().setData(req));
        return obj;
    }
    
    
    public Bus find(long id) {
 
        String req = "SELECT * From bus where "+ id;
        
        ResultSet result = MySQLManager.getInstance().getData(req);
        Bus bus = null;
        try {
            if (result.next()) {
            bus = new Bus(result.getString("busNumero"));
            bus.setId(result.getInt("cleBus"));
            
           /* String req2 ="SELECT * FROM operation where cleBus = "+bus.getCleBus();
            
            ResultSet result2 = MySQLManager.getInstance().getData(req2);
            
            try{
                while (result2.next()) {
                   //System.out.println(result2.);
                    bus.addOperation(result2.getString("intitule"),result2.getString("dateOperation"),result2.getFloat("montant"));                  
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
            System.out.println("pas bus");
        }
        
        return bus;  

    }
    
    public LinkedList<Bus> findall() {
         
        String req = "SELECT * From bus";
        LinkedList<Bus> buss = new LinkedList<Bus>();
        ResultSet result = MySQLManager.getInstance().getData(req);
        Bus bus = null;
        try {
            while(result.next()) {
                bus = new Bus(result.getString("busNumero"));
                bus.setId(result.getInt("busid"));
                
                /*String req2 = "SELECT * FROM operation Where cleBus = "+bus.getCleBus();
                
                ResultSet result2 = MySQLManager.getInstance().getData(req2);
                
                buss.add(bus);
                
                try{
                    while (result2.next()) {
                        bus.addOperation(result2.getString("intitule"),result2.getString("dateOperation"),result2.getFloat("montant"));                  
                    }
                    bus.toString();
                }
                catch(Exception e){
                    System.out.println(e.toString());
                    System.out.println("pas operations");
                }*/
            }       
        }
        catch(Exception e){
            System.out.println(e.toString());
            System.out.println("pas bus");
        }
        
        return buss; 

    }
    
    
    public Bus update(Bus obj) {
        String req = String.format("Update * From bus values(%s) Where %i", obj.getNumero());
        
        MySQLManager.getInstance().setData(req);
        return obj;
        
    }


    public void delete(Bus obj) {
        String req = String.format("DELETE From bus Where %i", obj.getId());
    }
    
    public void saveall(LinkedList<Bus> obj) {
        
        for (Bus bus : obj) {
            if (bus.getId()==0) {
                bus = create(bus);    
            }else {
                bus = update(bus);
            }
        }
        
    }
    
}
