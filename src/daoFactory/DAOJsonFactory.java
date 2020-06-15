package daoFactory;


import dao.ArretDAOJson;
import dao.BusDAOJson;
import dao.LigneDAOJson;
import dao.DAO;

public class DAOJsonFactory extends DAOFactory {
    private static DAOJsonFactory instance;
    
    private DAOJsonFactory() { 
    }
    
    public static synchronized DAOFactory getInstance() {
        
        if (instance == null) {
            instance = new DAOJsonFactory();
        }
        return instance;        
    }

    public DAO getBusDAO() {
        return BusDAOJson.getInstance();
    };
    
    public DAO getArretDAO() {
        return ArretDAOJson.getInstance();
    }
    
    public DAO getLigneDAO() {
        return LigneDAOJson.getInstance();
    }
}
