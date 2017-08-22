<%-- 
    Document   : 500
    Created on : Jun 19, 2017, 6:22:16 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error on server.</title>
	<!--Choise header-->
	<c:if test="${sessionScope.header eq null}" >
	    <jsp:include page="../header.jsp"></jsp:include>
	</c:if>
	<c:if test="${sessionScope.header ne null}" >
	    <jsp:include page="../${sessionScope.header}"></jsp:include>
	</c:if>
    </head>
    <body>
	<a href="index.jsp">
	    <center>
		<h1>
		    MAIN PAGE
		</h1>
	    </center>
	</a>
    <center>
	<h1>
	    WARNING! ERROR
	</h1>
	<p>
	    ${requestScope.errorMessage}
	</p>
    </center>
</body>
</html>

<%@include file="../footer.jsp" %>
