package by.epam.web.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.web.bean.User;
import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.ClientService;

public class SignInAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory factory = ServiceFactory.getInstance();
		ClientService clientService = factory.getClientService();
		User user = null;
		HttpSession session = null;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		 try{
			 user = clientService.signIn(login, password);
			 session = request.getSession();
			 session.setAttribute("User", user);
		 }
		 catch(ServiceException e){
			 return "Error";
		 }
		return "authorized/UserPage";
	}

}
