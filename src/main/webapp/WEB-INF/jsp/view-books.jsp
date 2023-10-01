<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<!DOCTYPE html>
<html>
    <head>
        <title>View Books</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
    <c:catch var="exception">${user.email}</c:catch>
        <c:choose>
            <c:when test="${user != null}">
            <h2> Benvenuto ${user.name} ecco i tuoi libri</h2>
            </c:when>
         </c:choose>
        <table>
            <thead>
                <tr>
                    <th>ISBN</th>
					<th>Author</th>
					<th>Title</th>
					<th>Time added</th>
					<th>Time removed</th>
					<th>Plot</th>
					<th>Number of readings</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${books}" var="book">
                    <tr>
                       <td th:text="${book.ISBN}"></td>
										<td th:text="${book.Author}"></td>
										<td th:text="${book.Title}"></td>
										<td th:text="${book.Time_added}"></td>
										<td th:text="${book.Time_removed}"></td>
										<td th:text="${book.Plot}"></td>
										<td th:text="${book.Num_readings}"></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>