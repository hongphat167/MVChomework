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

@WebServlet("/publisher/edit.html")
public class PublisherEditController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PublisherRepository repository = new PublisherRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("o", repository.getPublisher(id));
			request.getRequestDispatcher("/views/publisher/edit.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.getParameter("name").equals("")) {
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				if (repository.edit(new Publisher(id, request.getParameter("name"))) > 0) {
					response.sendRedirect(request.getContextPath() + "/admin/publisher.html");
				} else {
					request.setAttribute("msg", "Edit Failed");
					doGet(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
