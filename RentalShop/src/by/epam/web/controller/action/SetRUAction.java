package by.epam.web.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.web.controller.Action;
import by.epam.web.service.exception.ServiceException;

public class SetRUAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
		HttpSession session = request.getSession();
		String local = (String) session.getAttribute("local");
		if (!local.equals("ru_RU")) {session.setAttribute("local", "ru_RU");
		}
		return "index";
	}

}
