package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDAO;
import model.Movie;

@WebServlet("/")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieDAO movieDAO;

	public void init() {
		movieDAO = new MovieDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertMovie(request, response);
				break;
			case "/delete":
				deleteMovie(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateMovie(request, response);
				break;
			default:
				listMovie(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listMovie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Movie> listMovie = movieDAO.selectAllMovies();
		request.setAttribute("listMovie", listMovie);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Movie existingMovie = movieDAO.selectMovie(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("movie", existingMovie);
		dispatcher.forward(request, response);

	}

	private void insertMovie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		int movieId = Integer.parseInt(request.getParameter("movieId"));
		String movieTitle = request.getParameter("movieTitle");
		int movieYear = Integer.parseInt(request.getParameter("movieYear"));
		int movieTime = Integer.parseInt(request.getParameter("movieTime"));
		String movieLanguage = request.getParameter("movieLanguage");
		String movieReleasingDate = request.getParameter("movieReleasingDate");
		String movieReleasingCountry = request.getParameter("movieReleasingCountry");
		int directorId = Integer.parseInt(request.getParameter("directorId"));
		String directorFirstName = request.getParameter("directorFirstName");
		String directorLastName = request.getParameter("directorLastName");
		int actorId = Integer.parseInt(request.getParameter("actorId"));
		String actorFirstName = request.getParameter("actorFirstName");
		String actorLastName = request.getParameter("actorLastName");
		String actorGender = request.getParameter("actorGender");

		Movie newMovie = new Movie(movieId, movieTitle, movieYear, movieTime, movieLanguage, movieReleasingDate,
				movieReleasingCountry, directorId, directorFirstName, directorLastName, actorId, actorFirstName,
				actorLastName, actorGender);
		movieDAO.insertMovie(newMovie);
		response.sendRedirect("list");
	}

	private void updateMovie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		int movieId = Integer.parseInt(request.getParameter("movieId"));
		String movieTitle = request.getParameter("movieTitle");
		int movieYear = Integer.parseInt(request.getParameter("movieYear"));
		int movieTime = Integer.parseInt(request.getParameter("movieTime"));
		String movieLanguage = request.getParameter("movieLanguage");
		String movieReleasingDate = request.getParameter("movieReleasingDate");
		String movieReleasingCountry = request.getParameter("movieReleasingCountry");
		int directorId = Integer.parseInt(request.getParameter("directorId"));
		String directorFirstName = request.getParameter("directorFirstName");
		String directorLastName = request.getParameter("directorLastName");
		int actorId = Integer.parseInt(request.getParameter("actorId"));
		String actorFirstName = request.getParameter("actorFirstName");
		String actorLastName = request.getParameter("actorLastName");
		String actorGender = request.getParameter("actorGender");

		Movie updateMovie = new Movie(movieId, movieTitle, movieYear, movieTime, movieLanguage, movieReleasingDate,
				movieReleasingCountry, directorId, directorFirstName, directorLastName, actorId, actorFirstName,
				actorLastName, actorGender);

		movieDAO.updateMovie(updateMovie);
		response.sendRedirect("list");
	}

	private void deleteMovie(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		movieDAO.deleteMovie(id);
		response.sendRedirect("list");

	}
}