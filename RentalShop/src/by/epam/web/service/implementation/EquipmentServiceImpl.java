package by.epam.web.service.implementation;

import java.util.ArrayList;
import java.util.List;

import by.epam.web.bean.Equipment;
import by.epam.web.dao.exception.DAOException;
import by.epam.web.dao.factory.DAOFactory;
import by.epam.web.dao.interfaces.EquipmentDAO;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.interfaces.EquipmentService;

public class EquipmentServiceImpl implements EquipmentService {

	@Override
	public void addEquipment(Equipment e) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		EquipmentDAO equipmentDAO = factory.getEquipmentDAO();
		
		try {
			equipmentDAO.addEquipment(e);
		} catch (DAOException e1) {
			throw new ServiceException(e1);
		}

	}

	@Override
	public void deleteEquipmentById(int id) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		EquipmentDAO equipmentDAO = factory.getEquipmentDAO();
		
		try {
			equipmentDAO.deleteByID(id);
		} catch (DAOException e1) {
			throw new ServiceException(e1);
		}

	}


	@Override
	public List<Equipment> getAllEquipment() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		EquipmentDAO equipmentDAO = factory.getEquipmentDAO();
		List<Equipment> list = null;
		try {
			list = equipmentDAO.getAllEquipment();
		} catch (DAOException e1) {
			throw new ServiceException(e1);
		}
		return list;
	}

	@Override
	public Equipment getEquipmentById(int id) throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		EquipmentDAO equipmentDAO = factory.getEquipmentDAO();
		Equipment equipment = null;
		try{
			equipment = equipmentDAO.getEquipmentById(id);
		} catch(DAOException e){
			throw new ServiceException(e);
		}
		return equipment;
	}

}
