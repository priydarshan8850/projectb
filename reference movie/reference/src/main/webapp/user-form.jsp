<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>User Management Application</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
<%-- 
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
			<div>
				<a href="" class="navbar-brand"> User Management App </a>
			</div>

			<ul class="navbar-nav">
				<li>
					<a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a>
				</li>
			</ul>
		</nav>
	</header> --%>

	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${movie != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${movie == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${movie != null}">
                                    Edit Movie
                                </c:if>
						<c:if test="${movie == null}">
                                    Add New Movie
                                </c:if>
					</h2>
				</caption>

				<fieldset class="form-group">
					<label>Movie ID</label>
					<input type="text" value="<c:out value='${movie.getMovieId()}' />" class="form-control" name="movieId" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Movie Title</label>
					<input type="text" value="<c:out value='${movie.getMovieTitle()}' />" class="form-control" name="movieTitle" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Movie Year</label>
					<input type="text" value="<c:out value='${movie.getMovieYear()}' />" class="form-control" name="movieYear">
				</fieldset>

				<fieldset class="form-group">
					<label>Movie Time</label>
					<input type="text" value="<c:out value='${movie.getMovieTime()}' />" class="form-control" name="movieTime">
				</fieldset>

				<fieldset class="form-group">
					<label>Movie Language</label>
					<input type="text" value="<c:out value='${movie.getMovieLanguage()}' />" class="form-control" name="movieLanguage">
				</fieldset>

				<fieldset class="form-group">
					<label>Movie Releasing Date</label>
					<input type="text" value="<c:out value='${movie.getMovieReleasingDate()}' />" class="form-control" name="movieReleasingDate">
				</fieldset>

				<fieldset class="form-group">
					<label>Movie Releasing Country</label>
					<input type="text" value="<c:out value='${movie.getMovieReleasingCountry()}' />" class="form-control" name="movieReleasingCountry">
				</fieldset>

				<fieldset class="form-group">
					<label>Director Id</label>
					<input type="text" value="<c:out value='${movie.getDirectorId()}' />" class="form-control" name="directorId">
				</fieldset>

				<fieldset class="form-group">
					<label>Director First Name</label>
					<input type="text" value="<c:out value='${movie.getDirectorFirstName()}' />" class="form-control" name="directorFirstName">
				</fieldset>

				<fieldset class="form-group">
					<label>Director Last Name</label>
					<input type="text" value="<c:out value='${movie.getDirectorLastName()}' />" class="form-control" name="directorLastName">
				</fieldset>

				<fieldset class="form-group">
					<label>Actor Id</label>
					<input type="text" value="<c:out value='${movie.getActorId()}' />" class="form-control" name="actorId">
				</fieldset>

				<fieldset class="form-group">
					<label>Actor First Name</label>
					<input type="text" value="<c:out value='${movie.getActorFirstName()}' />" class="form-control" name="actorFirstName">
				</fieldset>

				<fieldset class="form-group">
					<label>Actor Last Name</label>
					<input type="text" value="<c:out value='${movie.getActorLastName()}' />" class="form-control" name="actorLastName">
				</fieldset>

				<fieldset class="form-group">
					<label>Actor Gender</label>
					<input type="text" value="<c:out value='${movie.getActorGender()}' />" class="form-control" name="actorGender">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>