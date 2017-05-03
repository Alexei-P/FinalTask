package by.epam.web.service.implementation;

import by.epam.web.bean.Cart;
import by.epam.web.bean.User;
import by.epam.web.dao.exception.DAOException;
import by.epam.web.dao.factory.DAOFactory;
import by.epam.web.dao.interfaces.CartDAO;
import by.epam.web.dao.interfaces.UserDAO;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.interfaces.ClientService;

public class ClientServiceImpl implements ClientService {

	@Override
	public User signIn(String login, String password) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		User user = null;
		try {
			user = userDAO.signIn(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return user;
	}

	@Override
	public void signOut(String login) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		
		try {
			userDAO.signOut(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void register(User user) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		
		try {
			userDAO.register(user);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public Cart addCart(Cart cart) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		CartDAO cartDAO = factory.getCartDAO();
		try{
			cartDAO.addCart(cart);
		}catch(DAOException e){
			throw new ServiceException(e);
		}
		return cart;
	}

}
