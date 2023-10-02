<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<html>
    <head>
        <title>View Books</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
    <c:catch var="exception">${user.email}</c:catch>
    <c:choose>
        <c:when test="${user != null}">

            Benvenuto ${user.name}

        </c:when>
        <c:otherwise>
            <form action="/login" method="post">
                <label for="exampleInputEmail1">Email address</label>
                <input type="text" name="email" placeholder="Email address"
                /><br/><br/>
                <label for="exampleInputPassword1">Password</label><input type="password" name="password" placeholder="Password"
                /><br/><br/>
                <div class="form-group">
                	<div class="row">
                			<div class="col-sm-6 col-sm-offset-3">
                				<input type="submit" name="login-submit" id="login-submit"
                				class="btn btn-primary" type="submit" value="login" />
                			</div>
                	</div>
                </div>
                <%--<input type="submit" value="login"/>--%>
            </form>
        </c:otherwise>
    </c:choose>

    </body>
</html>
