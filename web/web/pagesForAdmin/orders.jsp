<%-- 
    Document   : orders
    Created on : Jun 13, 2017, 10:35:50 AM
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
		<td><h1 align="center">${applicationScope.ORDERS}</h1></td>
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
			    <th>${applicationScope.dateOfBegining}</th>
			    <th>${applicationScope.dateOfEnding}</th>
			    <th>${applicationScope.manufacturer}</th>
			    <th>${applicationScope.color}</th>
			    <th>${applicationScope.transmission}</th>
			    <th>${applicationScope.bodyType}</th>
			    <th>${applicationScope.power}</th>
			    <th>${applicationScope.free}</th>
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
			<c:forEach items="${requestScope.listOrders}" var="order">
			    <tr>
				<td>${order.id}</td>
				<td>${order.dateOfBegining}</td>
				<td>${order.dateOfEnding}</td>
				<td>${order.car.manufacturer.manufacturer}</td>
				<td>${order.car.model.color}</td>
				<td>${order.car.model.transmission}</td>
				<td>${order.car.model.bodyType}</td>
				<td>${order.car.model.power}</td>
				<td>${order.car.free}</td>
				<td>${order.client.passport}</td>
				<td>${order.client.firstName}</td>
				<td>${order.client.lastName}</td>
				<td>${order.client.fatherName}</td>
				<td>${order.client.numberPhone}</td>
				<td>${order.client.email}</td>
				<td>${order.client.user.login}</td>
				<td>${order.client.user.password}</td>
				<td>${order.client.user.role.role}</td>
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