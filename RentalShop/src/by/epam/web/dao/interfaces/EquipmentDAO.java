package by.epam.web.dao.interfaces;

import java.util.ArrayList;
import java.util.List;

import by.epam.web.bean.Equipment;
import by.epam.web.dao.exception.DAOException;

public interface EquipmentDAO {
	Equipment addEquipment(Equipment e) throws DAOException;
	Equipment deleteEquipment(Equipment e) throws DAOException;
	int deleteByID(int id) throws DAOException;
	List<Equipment> getAllEquipment() throws DAOException;
	int getEquipmentId(String equipment) throws DAOException;
	Equipment getEquipmentById(int id) throws DAOException;
}
