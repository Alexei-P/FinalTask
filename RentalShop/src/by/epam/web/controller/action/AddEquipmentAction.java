package by.epam.web.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.web.bean.Equipment;
import by.epam.web.controller.Action;
import by.epam.web.dao.interfaces.EquipmentDAO;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.EquipmentService;

public class AddEquipmentAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		ServiceFactory factory = ServiceFactory.getInstance();
		EquipmentService equipmentDAO = factory.getEquipmentService();
		Equipment equipment = null;
		String name = request.getParameter("name");
		double cost = Double.parseDouble(request.getParameter("cost"));
		double price = Double.parseDouble(request.getParameter("price"));
		equipment = new Equipment(name, cost, price);
		try {
			equipmentDAO.addEquipment(equipment);
		} catch (ServiceException e) {
			throw new ServiceException(e);
		}
		return "Products";
	}

}
