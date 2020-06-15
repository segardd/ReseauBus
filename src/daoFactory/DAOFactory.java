package daoFactory;

import dao.DAO;
import modele.Arret;
import modele.Bus;
import modele.Ligne;

public abstract class DAOFactory{
	
	public enum SourcesDonnees{
		mySQL,
		JSON
	}
	
	public abstract DAO<Bus> getBusDAO();

	public abstract DAO<Arret> getArretDAO();
    
    public abstract DAO<Ligne> getLigneDAO();
    
	
	public static DAOFactory getFactory(SourcesDonnees sd) 
	{
			switch(sd) {
			case mySQL:
				return DAOMySQLFactory.getInstance();
			}
			return null;
		
	};
	
}
