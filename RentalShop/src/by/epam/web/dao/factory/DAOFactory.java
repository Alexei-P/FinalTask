package by.epam.web.dao.factory;

import by.epam.web.dao.implementation.SQLCartDAO;
import by.epam.web.dao.implementation.SQLEquipmentDAO;
import by.epam.web.dao.implementation.SQLItemDAO;
import by.epam.web.dao.implementation.SQLUserDAO;
import by.epam.web.dao.interfaces.CartDAO;
import by.epam.web.dao.interfaces.EquipmentDAO;
import by.epam.web.dao.interfaces.ItemDAO;
import by.epam.web.dao.interfaces.UserDAO;

public class DAOFactory {
	private static final DAOFactory instance = new DAOFactory();
	
	private final UserDAO sqlUserDAO = new SQLUserDAO();
	private final EquipmentDAO sqlEquipmentDAO = new SQLEquipmentDAO();
	private final ItemDAO sqlItemDAO = new SQLItemDAO();
	private final CartDAO sqlCartDAO = new SQLCartDAO();
	
	private DAOFactory(){}
	
	public static DAOFactory getInstance(){
		return instance;
	}
	
	public UserDAO getUserDAO(){
		return sqlUserDAO;
	}
	public EquipmentDAO getEquipmentDAO(){
		return sqlEquipmentDAO;
	}
	public ItemDAO getItemDAO(){
		return sqlItemDAO;
	}
	
	public CartDAO getCartDAO(){
		return sqlCartDAO;
	}
}
