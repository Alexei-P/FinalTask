package by.epam.web.dao.interfaces;

import java.sql.Date;
import java.util.List;

import by.epam.web.bean.Item;
import by.epam.web.dao.exception.DAOException;

public interface ItemDAO {
	void createItem(int equipment_id, int user_id, int quantity) throws DAOException;
	List<Item> getAllItems() throws DAOException;
	int deleteItem(int id) throws DAOException;
	List<Item> getItemsByUserId(int id) throws DAOException;
}
