package by.epam.web.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.web.bean.Cart;
import by.epam.web.bean.Equipment;
import by.epam.web.bean.Item;
import by.epam.web.bean.User;
import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.EquipmentService;

public class AddToCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		Item item = null;
		Equipment equipment = null;
		User user = (User) request.getSession().getAttribute("User");
		int equipmentId = Integer.parseInt(request.getParameter("addToCart"));
		ServiceFactory factory = ServiceFactory.getInstance();
		EquipmentService equipmentService = factory.getEquipmentService();
		try {
			equipment = equipmentService.getEquipmentById(equipmentId);
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			if (quantity == 0) return "authorized/Products";
			item = new Item(quantity, equipment, user);
			Cart cart = (Cart) request.getSession().getAttribute("cart");
			cart.addItem(item);
		} catch (ServiceException e) {
			throw new ServiceException(e);
		}
		return "authorized/Products";
	}

}
