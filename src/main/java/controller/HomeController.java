package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import model.ProductRepository;

@WebServlet("/home.html")
public class HomeController extends GenericServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int size = 8;
	ProductRepository repository = new ProductRepository();

	private int getPage(int total) {
		return (int) Math.ceil(total / (float) size);
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int p = 1;
		if (req.getParameter("p") != null) {
			p = Integer.parseInt(req.getParameter("p"));
		}
		try {
			req.setAttribute("n", getPage(repository.count()));
			req.setAttribute("list", repository.getProducts(p, size));
			req.getRequestDispatcher("/views/home/index.jsp").forward(req, res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
