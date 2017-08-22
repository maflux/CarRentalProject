<%-- 
    Document   : testPage
    Created on : Jun 12, 2017, 4:33:17 PM
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TEST PAGE</title>
	<%--<%@include file="header.jsp"%>--%>
	<c:if test="${sessionScope.header eq null}" >
	    <jsp:include page="header.jsp"></jsp:include>

	</c:if>
	<c:if test="${sessionScope.header ne null}" >
	    <jsp:include page="${sessionScope.header}"></jsp:include>
	</c:if>


    </head>
    <body>
	<table align="center" border="1" width="90%" height="90%">

	    <tr>
		<td>11</td>
		<td>12</td>
		<td>13</td>
	    </tr>
	    <tr>
		<td>21</td>
		<td align="center">
		    <p><b><h1>Please sign in or register.</h1></b></p>
		    <p><h2>Use frame on top-right.</h2></p>
		</td>
		<td>23</td>
	    </tr>
	    <tr>
		<td>31</td>
		<td>32</td>
		<td>33</td>
	    </tr>

	</table>
    </body>
</html>

<%@include file="footer.jsp" %>