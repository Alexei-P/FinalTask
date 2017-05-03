package by.epam.web.controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.web.bean.Item;
import by.epam.web.bean.User;
import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.ItemService;

public class GetItemsByUserIdAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("User");
		if (user!=null){
		int id = user.getId();
		ServiceFactory factory = ServiceFactory.getInstance();
		ItemService itemService = factory.getItemService();
		ArrayList<Item> list = (ArrayList<Item>) itemService.getItemsByUserId(id);
		request.setAttribute("UserItems", list);
		return "authorized/UserPage";
		} else return "Registration";
	}

}
