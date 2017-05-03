package by.epam.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import by.epam.web.service.exception.ServiceException;

/**
 * Servlet implementation class RentalShopController
 */
@WebServlet("/RentalShopController")
public class RentalShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static Logger logger = LogManager.getLogger("logger");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RentalShopController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String startLog1 = "Exception in method doGet, case: ";
		HttpSession session = request.getSession();
		ActionFactory factory = ActionFactory.getInstance();
		String result = null;
		Action action = null;
		String pageParam = request.getParameter("action");
		if (pageParam != null) {
			RequestDispatcher dispatcher = null;
			switch (pageParam) {
			case "Products":
				
				action = factory.getAction("GET_ALL_EQUIPMENT");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e1) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("jsps/authorized/" + result + ".jsp");
				dispatcher.forward(request, response);
				break;
			case "About":
				dispatcher = request.getRequestDispatcher("jsps/About.jsp");
				dispatcher.forward(request, response);
				break;
			case "Registration":
				dispatcher = request.getRequestDispatcher("jsps/Registration.jsp");
				dispatcher.forward(request, response);
				break;
			case "getAllEquipment":
				action = factory.getAction("GET_ALL_EQUIPMENT");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("jsps/authorized/" + result + ".jsp");
				dispatcher.forward(request, response);
				break;
			case "getAllEquipmentAdmin":
				action = factory.getAction("GET_ALL_EQUIPMENT");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("jsps/authorized/Admin.jsp");
				dispatcher.forward(request, response);
				break;
			case "Cart":
				dispatcher = request.getRequestDispatcher("jsps/authorized/Cart.jsp");
				dispatcher.forward(request, response);
				break;
			case "Welcome":
				dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
				break;
			case "DeleteFromCart":
				action = factory.getAction("DELETE_FROM_CART");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("jsps/" + result + ".jsp");
				dispatcher.forward(request, response);
				break;
			case "AddCart":
				action = factory.getAction("ADD_CART");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("jsps/" + result + ".jsp");
				dispatcher.forward(request, response);
				break;
			case "SignOut":
				action = factory.getAction("SIGN_OUT");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("/" + result + ".jsp");
				dispatcher.forward(request, response);
				break;
			case "UserPage":
				action = factory.getAction("GET_USER_ITEMS");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("jsps/" + result + ".jsp");
				dispatcher.forward(request, response);
				break;
			case "DeleteFromOrders":
				action = factory.getAction("DELETE_ITEM_BY_ID");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("jsps/authorized/" + result + ".jsp");
				dispatcher.forward(request, response);
				break;
			case "EN":
				action = factory.getAction("SET_EN");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("");
				dispatcher.forward(request, response);
				break;
			case "RU":
				action = factory.getAction("SET_RU");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("");
				dispatcher.forward(request, response);
				break;
			case "Admin":
				dispatcher = request.getRequestDispatcher("jsps/authorized/Admin.jsp");
				dispatcher.forward(request, response);
				break;
			case "getAllUsers":
				action = factory.getAction("GET_ALL_USERS");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("jsps/authorized/" + result + ".jsp");
				dispatcher.forward(request, response);
				break;
			case "AddEquipment":
				action = factory.getAction("ADD_EQUIPMENT");
				try {
					result = action.execute(request, response);
				} catch (ServiceException e) {
					logger.info(startLog1 + pageParam);
				}
				dispatcher = request.getRequestDispatcher("jsps/authorized/Admin.jsp");
				dispatcher.forward(request, response);
				break;
			default:
				dispatcher = request.getRequestDispatcher("jsps/Error.jsp");
				dispatcher.forward(request, response);
				break;
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String startLog2 = "Exception in method doPost, case: ";
		String pageParam = request.getParameter("actionPOST");
		ActionFactory factory = ActionFactory.getInstance();
		Action action = null;
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		String result = "";
		switch (pageParam) {
		case "Login":
			action = factory.getAction("SIGN_IN");
			try {
				result = action.execute(request, response);
			} catch (ServiceException e) {
				logger.info(startLog2 + pageParam);
			}
			rd = request.getRequestDispatcher("jsps/" + result + ".jsp");
			rd.forward(request, response);
			break;
		case "Register":
			action = factory.getAction("REGISTER");
			try {
				result = action.execute(request, response);
			} catch (ServiceException e) {
				logger.info(startLog2 + pageParam);
			}
			response.sendRedirect(result + ".jsp");
			break;
		case "AddToCart":
			action = factory.getAction("ADD_TO_CART");
			try {
				result = action.execute(request, response);
			} catch (ServiceException e) {
				logger.info(startLog2 + pageParam);
			}
			rd = request.getRequestDispatcher("jsps/" + result + ".jsp");
			rd.forward(request, response);
			break;
		case "UpdateCart":
			action = factory.getAction("UPDATE_CART");
			try {
				result = action.execute(request, response);
			} catch (ServiceException e) {
				logger.info(startLog2 + pageParam);
			}
			rd = request.getRequestDispatcher("jsps/" + result + ".jsp");
			rd.forward(request, response);
			break;
		case "DeleteFromCart":
			action = factory.getAction("DELETE_FROM_CART");
			try {
				result = action.execute(request, response);
			} catch (ServiceException e) {
				logger.info(startLog2 + pageParam);
			}
			rd = request.getRequestDispatcher("jsps/" + result + ".jsp");
			rd.forward(request, response);
			break;
		default:
			rd = request.getRequestDispatcher("jsps/Error.jsp");
			rd.forward(request, response);
			break;
		}
	}

}
