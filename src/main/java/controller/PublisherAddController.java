package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Publisher;
import model.PublisherRepository;

@WebServlet("/publisher/add.html")
public class PublisherAddController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PublisherRepository repository = new PublisherRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/publisher/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameter("name").equals("")) {
			try {
				if (repository.add(new Publisher(0, request.getParameter("name"))) > 0) {
					response.sendRedirect(request.getContextPath() + "/admin/publisher.html");
				} else {
					request.setAttribute("msg", "Inserted Failed");
					doGet(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
