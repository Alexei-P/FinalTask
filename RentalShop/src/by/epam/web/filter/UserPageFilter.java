package by.epam.web.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.web.bean.Item;
import by.epam.web.bean.User;
import by.epam.web.service.exception.ServiceException;
import by.epam.web.service.factory.ServiceFactory;
import by.epam.web.service.interfaces.ItemService;

/**
 * Servlet Filter implementation class UserPageFilter
 */
public class UserPageFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserPageFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("User");
		System.out.println(user);
		if (user!=null){
		int id = user.getId();
		ServiceFactory factory = ServiceFactory.getInstance();
		ItemService itemService = factory.getItemService();
		ArrayList<Item> list = null;
		try {
			list = (ArrayList<Item>) itemService.getItemsByUserId(id);
		} catch (ServiceException e) {
			e.printStackTrace();
			//TODO logging
		}
		request.setAttribute("UserItems", list);
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
		else{
			res.sendRedirect("jsps/Registration.jsp");
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
