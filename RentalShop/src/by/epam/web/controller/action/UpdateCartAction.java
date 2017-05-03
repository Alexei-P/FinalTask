package by.epam.web.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.web.bean.Cart;
import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;

public class UpdateCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		int id;
		int quantity;
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		id = Integer.parseInt(request.getParameter("update"));
		quantity = Integer.parseInt(request.getParameter("quantity"));
		cart.setItemQuantity(id, quantity);
		session.setAttribute("cart", cart);
		
		return "authorized/Cart";
	}

}
