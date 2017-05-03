package by.epam.web.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.web.bean.User;
import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.ClientService;

public class RegisterAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		ServiceFactory factory = ServiceFactory.getInstance();
		ClientService userService = factory.getClientService();
		HttpSession session = null;
		User user = new User(request.getParameter("login"), request.getParameter("password"));
		try{
			userService.register(user);
		}
		catch(ServiceException e){
			throw new ServiceException(e);
		}
		session = request.getSession();
		session.setAttribute("User", user);
		return "index";
	}

}
