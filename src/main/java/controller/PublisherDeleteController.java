package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PublisherRepository;

@WebServlet("/publisher/del.html")
public class PublisherDeleteController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PublisherRepository repository = new PublisherRepository();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				repository.delete(id);
				response.sendRedirect(request.getContextPath() + "/publisher.html");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
