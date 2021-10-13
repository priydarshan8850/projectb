package model;

public class Movie {

	private int movieId;
	private String movieTitle;
	private int movieYear;
	private int movieTime;
	private String movieLanguage;
	private String movieReleasingDate;
	private String movieReleasingCountry;
	private int directorId;
	private String directorFirstName;
	private String directorLastName;
	private int actorId;
	private String actorFirstName;
	private String actorLastName;
	private String actorGender;

	public Movie(int movieId, String movieTitle, int movieYear, int movieTime, String movieLanguage,
			String movieReleasingDate, String movieReleasingCountry, int directorId, String directorFirstName,
			String directorLastName, int actorId, String actorFirstName, String actorLastName, String actorGender) {
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieYear = movieYear;
		this.movieTime = movieTime;
		this.movieLanguage = movieLanguage;
		this.movieReleasingDate = movieReleasingDate;
		this.movieReleasingCountry = movieReleasingCountry;
		this.directorId = directorId;
		this.directorFirstName = directorFirstName;
		this.directorLastName = directorLastName;
		this.actorId = actorId;
		this.actorFirstName = actorFirstName;
		this.actorLastName = actorLastName;
		this.actorGender = actorGender;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

	public int getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(int movieTime) {
		this.movieTime = movieTime;
	}

	public String getMovieLanguage() {
		return movieLanguage;
	}

	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	public String getMovieReleasingDate() {
		return movieReleasingDate;
	}

	public void setMovieReleasingDate(String movieReleasingDate) {
		this.movieReleasingDate = movieReleasingDate;
	}

	public String getMovieReleasingCountry() {
		return movieReleasingCountry;
	}

	public void setMovieReleasingCountry(String movieReleasingCountry) {
		this.movieReleasingCountry = movieReleasingCountry;
	}

	public int getDirectorId() {
		return directorId;
	}

	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}

	public String getDirectorFirstName() {
		return directorFirstName;
	}

	public void setDirectorFirstName(String directorFirstName) {
		this.directorFirstName = directorFirstName;
	}

	public String getDirectorLastName() {
		return directorLastName;
	}

	public void setDirectorLastName(String directorLastName) {
		this.directorLastName = directorLastName;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getActorFirstName() {
		return actorFirstName;
	}

	public void setActorFirstName(String actorFirstName) {
		this.actorFirstName = actorFirstName;
	}

	public String getActorLastName() {
		return actorLastName;
	}

	public void setActorLastName(String actorLastName) {
		this.actorLastName = actorLastName;
	}

	public String getActorGender() {
		return actorGender;
	}

	public void setActorGender(String actorGender) {
		this.actorGender = actorGender;
	}

}
