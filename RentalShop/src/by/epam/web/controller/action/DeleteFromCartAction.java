package by.epam.web.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.web.bean.Cart;
import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;

public class DeleteFromCartAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		int id;
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		id = Integer.parseInt(request.getParameter("delete"));
		cart.removeItemById(id);
		session.setAttribute("cart", cart);
		return "authorized/Cart";
	}

}
