package daoFactory;

import dao.ArretDAOMySQL;
import dao.BusDAOMySQL;
import dao.DAO;
import dao.LigneDAOMySQL;

public class DAOMySQLFactory extends DAOFactory{
	private static DAOMySQLFactory instance;
	
	private DAOMySQLFactory() {	
	}
	
	public static synchronized DAOMySQLFactory getInstance() {
		
		if (instance == null) {
			instance = new DAOMySQLFactory();
		}
		return instance;		
	}
	
	public DAO getBusDAO() {
        return BusDAOMySQL.getInstance();
    };

	public DAO getArretDAO() {
		return ArretDAOMySQL.getInstance();
	};
	
	public DAO getLigneDAO() {
		return LigneDAOMySQL.getInstance();
	}
	
	  
}

