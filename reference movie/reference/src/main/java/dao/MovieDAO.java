package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Movie;

public class MovieDAO {
	private String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe";
	private String jdbcUsername = "system";
	private String jdbcPassword = "system";

	private static final String INSERT = "INSERT INTO movies VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private static final String SELECT_BY_TITLE = "select * from movies where movieid = ?";
	private static final String SELECT_ALL = "select * from movies";
	private static final String DELETE = "delete from movies where movieid = ?";
	private static final String UPDATE = "update movies set movieid = ?, movietitle = ?, movieyear = ?, movietime = ?, movielanguage = ?,moviereleasingdate = ?,moviereleasingcountry= ?,directorid = ?,directorfirstname = ?,directorlastname = ?, actorid = ?,actorfirstname = ?,actorlastname = ?,actorgender =?  where movieid = ?";

	public MovieDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertMovie(Movie movie) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {

			preparedStatement.setInt(1, movie.getMovieId());
			preparedStatement.setString(2, movie.getMovieTitle());
			preparedStatement.setInt(3, movie.getMovieYear());
			preparedStatement.setInt(4, movie.getMovieTime());
			preparedStatement.setString(5, movie.getMovieLanguage());
			preparedStatement.setString(6, movie.getMovieReleasingDate());
			preparedStatement.setString(7, movie.getMovieReleasingCountry());
			preparedStatement.setInt(8, movie.getDirectorId());
			preparedStatement.setString(9, movie.getDirectorFirstName());
			preparedStatement.setString(10, movie.getDirectorLastName());
			preparedStatement.setInt(11, movie.getActorId());
			preparedStatement.setString(12, movie.getActorFirstName());
			preparedStatement.setString(13, movie.getActorLastName());
			preparedStatement.setString(14, movie.getActorGender());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Movie selectMovie(int id) {
		Movie movie = null;

		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_TITLE);) {
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				int movieId = rs.getInt(1);
				String movieTitle = rs.getString(2);
				int movieYear = rs.getInt(3);
				int movieTime = rs.getInt(4);
				String movieLanguage = rs.getString(5);
				String movieReleasingDate = rs.getString(6);
				String movieReleasingCountry = rs.getString(7);
				int directorId = rs.getInt(8);
				String directorFirstName = rs.getString(9);
				String directorLastName = rs.getString(10);
				int actorId = rs.getInt(11);
				String actorFirstName = rs.getString(12);
				String actorLastName = rs.getString(13);
				String actorGender = rs.getString(14);

				movie = new Movie(movieId, movieTitle, movieYear, movieTime, movieLanguage, movieReleasingDate,
						movieReleasingCountry, directorId, directorFirstName, directorLastName, actorId, actorFirstName,
						actorLastName, actorGender);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return movie;
	}

	public List<Movie> selectAllMovies() {

		List<Movie> movieList = new ArrayList<>();

		// using try-with-resources to avoid closing resources (boiler plate code)
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
			System.out.println(preparedStatement);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int movieId = rs.getInt(1);
				String movieTitle = rs.getString(2);
				int movieYear = rs.getInt(3);
				int movieTime = rs.getInt(4);
				String movieLanguage = rs.getString(5);
				String movieReleasingDate = rs.getString(6);
				String movieReleasingCountry = rs.getString(7);
				int directorId = rs.getInt(8);
				String directorFirstName = rs.getString(9);
				String directorLastName = rs.getString(10);
				int actorId = rs.getInt(11);
				String actorFirstName = rs.getString(12);
				String actorLastName = rs.getString(13);
				String actorGender = rs.getString(14);

				movieList.add(new Movie(movieId, movieTitle, movieYear, movieTime, movieLanguage, movieReleasingDate,
						movieReleasingCountry, directorId, directorFirstName, directorLastName, actorId, actorFirstName,
						actorLastName, actorGender));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return movieList;
	}

	public boolean deleteMovie(int id) throws SQLException {

		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE);) {
			statement.setString(1, String.valueOf(id));
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateMovie(Movie movie) throws SQLException {

		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE);) {

			statement.setInt(1, movie.getMovieId());
			statement.setString(2, movie.getMovieTitle());
			statement.setInt(3, movie.getMovieYear());
			statement.setInt(4, movie.getMovieTime());
			statement.setString(5, movie.getMovieLanguage());
			statement.setString(6, movie.getMovieReleasingDate());
			statement.setString(7, movie.getMovieReleasingCountry());
			statement.setInt(8, movie.getDirectorId());
			statement.setString(9, movie.getDirectorFirstName());
			statement.setString(10, movie.getDirectorLastName());
			statement.setInt(11, movie.getActorId());
			statement.setString(12, movie.getActorFirstName());
			statement.setString(13, movie.getActorLastName());
			statement.setString(14, movie.getActorGender());
			statement.setInt(15, movie.getMovieId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
