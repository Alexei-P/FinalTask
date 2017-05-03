package by.epam.web.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.AdminService;

public class DeleteUserAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		ServiceFactory factory = ServiceFactory.getInstance();
		AdminService adminService = factory.getAdminService();
		
		String id_ = request.getParameter("id");
		int id = Integer.parseInt(id_);
		
		try {
			adminService.deleteUser(id);
		} catch (ServiceException e) {
			throw new ServiceException(e);
		}
		return null;
	}

}
