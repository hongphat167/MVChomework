package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PublisherRepository;

@WebServlet("/admin/publisher.html")
public class PublisherController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PublisherRepository repository = new PublisherRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("list", repository.getPublishers());
			request.getRequestDispatcher("/views/publisher/index.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Integer> list = new LinkedList<>();
		for (String id : request.getParameterValues("ids")) {
			list.add(Integer.parseInt(id));
		}
		try {
			repository.delete(list);
			doGet(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
