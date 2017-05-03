package by.epam.web.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.web.bean.Cart;
import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.ClientService;

public class AddCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		ServiceFactory factory = ServiceFactory.getInstance();
		ClientService clientService = factory.getClientService();
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		clientService.addCart(cart);
		cart.getList().clear();
		session.setAttribute("cart", cart);
		return "authorized/Success";
	}

}
