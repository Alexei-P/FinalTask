package by.epam.web.dao.interfaces;

import by.epam.web.bean.Cart;
import by.epam.web.dao.exception.DAOException;

public interface CartDAO {
	Cart addCart(Cart cart) throws DAOException;
	int deleteCartById(int id) throws DAOException;
}
