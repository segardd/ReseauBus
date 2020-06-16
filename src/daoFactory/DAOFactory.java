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
	    DAOFactory type= null;
			switch(sd) {
			case mySQL:
				type = DAOMySQLFactory.getInstance();
				break;
			case JSON:
			    type = DAOJsonFactory.getInstance();
			    break;
			
			}
			
			return type;
			
			    
		
	};
	
}
