package by.epam.web.dao.interfaces;

import java.util.List;

import by.epam.web.bean.User;
import by.epam.web.dao.exception.DAOException;

public interface UserDAO {
	User signIn(String login, String password) throws DAOException;
	User register(User user) throws DAOException;
	int deleteUser(int id) throws DAOException;
	List<User> getAllUser() throws DAOException;
	String signOut(String login) throws DAOException;
}
