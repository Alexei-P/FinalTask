package by.epam.web.controller.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.web.bean.User;
import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.AdminService;

public class GetAllUsersAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		AdminService adminService = serviceFactory.getAdminService();
		List<User> list;
		try {
			list = adminService.getAllUsers();
			request.setAttribute("AllUsers", list);
			return "Admin";
		} catch (ServiceException e) {
			return "Error";
		}
	}

}
