package by.epam.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.web.service.exception.ServiceException;

public interface Action {
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException;
}
