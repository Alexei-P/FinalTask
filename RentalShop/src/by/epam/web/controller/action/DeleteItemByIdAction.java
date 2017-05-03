package by.epam.web.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.ItemService;

public class DeleteItemByIdAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		ServiceFactory factory = ServiceFactory.getInstance();
		ItemService itemService = factory.getItemService();
		int id = Integer.parseInt(request.getParameter("delete"));
		itemService.deleteItem(id);
		return "UserPage";
	}

}
