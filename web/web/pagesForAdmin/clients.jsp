<%-- 
    Document   : clients
    Created on : Jun 13, 2017, 10:16:02 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
	<c:if test="${sessionScope.header eq null}" >
	    <jsp:include page="../../header.jsp"></jsp:include>
	</c:if>
	<c:if test="${sessionScope.header ne null}" >
	    <jsp:include page="../../${sessionScope.header}"></jsp:include>
	</c:if>
    </head>
    <body>
        <table align="center" border="0" width="90%" height="90%">

	    <tr>
		<td>
		    <!--11-->
		</td>
		<td><h1 align="center">${applicationScope.CLIENTS}</h1></td>
		<td>
		    <!--13-->
		</td>
	    </tr>
	    <tr>
		<td>
		    <!--21-->
		</td>
		<td>
		    <table align="center" border="1">
			<tr>
			    <th>№</th>
			    <th>${applicationScope.passport}</th>
			    <th>${applicationScope.firstName}</th>
			    <th>${applicationScope.lastName}</th>
			    <th>${applicationScope.fatherName}</th>
			    <th>${applicationScope.numberPhone}</th>
			    <th>${applicationScope.email}</th>
			    <th>${applicationScope.login}</th>
			    <th>${applicationScope.password}</th>
			    <th>${applicationScope.role}</th>
			</tr>
			<c:forEach items="${requestScope.listClients}" var="client">
			    <tr>
				<td>${client.id}</td>
				<td>${client.passport}</td>
				<td>${client.firstName}</td>
				<td>${client.lastName}</td>
				<td>${client.fatherName}</td>
				<td>${client.numberPhone}</td>
				<td>${client.email}</td>
				<td>${client.user.login}</td>
				<td>${client.user.password}</td>
				<td>${client.user.role.role}</td>
			    </tr>
			</c:forEach>
		    </table>
		</td>
		<td>
		    <!--23-->
		</td>
	    </tr>
	    <tr>
		<td>
		    <!--31-->
		</td>
		<td>
		    <!--323-->
		</td>
		<td>
		    <!--33-->
		</td>
	    </tr>

	</table>
    </body>
</html>

<%@include file="../../footer.jsp" %>