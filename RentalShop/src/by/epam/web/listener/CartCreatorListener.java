package by.epam.web.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import by.epam.web.bean.Cart;

public class CartCreatorListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		Cart cart = new Cart();
		HttpSession session = arg0.getSession();
		session.setAttribute("cart", cart);
		String local = "en_EN";
		session.setAttribute("local", local);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
	}

}
