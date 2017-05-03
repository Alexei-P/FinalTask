package by.epam.web.controller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.web.bean.Equipment;
import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.EquipmentService;

public class GetAllEquipmentAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		ServiceFactory factory = ServiceFactory.getInstance();
		EquipmentService equipmentService = factory.getEquipmentService();
		List<Equipment> list;
		HttpSession session = null;
		try{
			list = equipmentService.getAllEquipment();
			session = request.getSession();
			session.setAttribute("EquipmentList", list);
		} catch(ServiceException e){
			throw new ServiceException(e);
		}
		return "Products";
	}

}
