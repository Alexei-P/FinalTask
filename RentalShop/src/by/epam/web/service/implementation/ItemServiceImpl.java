package by.epam.web.service.implementation;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.web.bean.Item;
import by.epam.web.dao.exception.DAOException;
import by.epam.web.dao.factory.DAOFactory;
import by.epam.web.dao.interfaces.ItemDAO;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.interfaces.ItemService;

public class ItemServiceImpl implements ItemService {
	@Override
	public void createItem(int equipment_id, int user_id, int quantity) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		ItemDAO ItemDAO = factory.getItemDAO();
		
		try {
			ItemDAO.createItem(equipment_id, user_id, quantity);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public List<Item> getItemsByUserId(int id) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		ItemDAO itemDAO = factory.getItemDAO();
		List<Item> list = null;
		try{
			list = itemDAO.getItemsByUserId(id);
		}catch(DAOException e){
			throw new ServiceException(e);
		}
		return list;
	}

	@Override
	public int deleteItem(int id) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		ItemDAO itemDAO = factory.getItemDAO();
		try{
			itemDAO.deleteItem(id);
		}catch(DAOException e){
			throw new ServiceException(e);
		}
		return id;
	}

	/*@Override
	public void closeItem(int id) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		ItemDAO ItemDAO = factory.getItemDAO();
		
		try {
			ItemDAO.closeItem(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}*/

	/*@Override
	public void openItem(int id) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		ItemDAO ItemDAO = factory.getItemDAO();
		
		try {
			ItemDAO.openItem(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
*/
}
