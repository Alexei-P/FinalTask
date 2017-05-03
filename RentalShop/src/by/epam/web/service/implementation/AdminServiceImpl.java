package by.epam.web.service.implementation;

import java.util.List;

import by.epam.web.bean.User;
import by.epam.web.dao.exception.DAOException;
import by.epam.web.dao.factory.DAOFactory;
import by.epam.web.dao.interfaces.UserDAO;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.interfaces.AdminService;

public class AdminServiceImpl implements AdminService {

	@Override
	public void deleteUser(int id) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		
		try {
			userDAO.deleteUser(id);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public List<User> getAllUsers() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		UserDAO userDAO = factory.getUserDAO();
		List<User> list;
		try {
			list = userDAO.getAllUser();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return list;
	}

}
