<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <title>View Books</title>
        <%-- <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css"> --%>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    </head>
    <body>
    <c:catch var="exception">${user.email}</c:catch>
        <c:choose>
            <c:when test="${user != null}">
            <h2> Benvenuto ${user.name} ecco i tuoi libri</h2>
            </c:when>
         </c:choose>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ISBN</th>
					<th scope="col">Author</th>
					<th scope="col">Title</th>
					<th scope="col">Time added</th>
					<th scope="col">Time removed</th>
					<th scope="col">Plot</th>
					<th scope="col">Number of readings</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${books}" var="book">
                    <tr >"
                       <th scope="row">"${book.id}"</th>
                       <td>"${book.isbn}"</td>
					   <td>"${book.author}"</td>
                       <td>"${book.title}"</td>
                       <td>"${book.time_added}"</td>
                       <td>"${book.time_removed}"</td>
                       <td>"${book.plot}"</td>
                       <td>"${book.num_readings}"</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
                <form action="/" method="get">
                <div class="form-group">
                						<div class="row">
                							<div class="col-sm-6 col-sm-offset-3">
                								<input type="submit" name="login-submit" id="login-submit"
                									class="btn btn-primary" type="submit" value="logout" />
                							</div>
                						</div>
                					</div>
                </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>