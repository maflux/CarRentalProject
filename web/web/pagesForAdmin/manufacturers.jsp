<%-- 
    Document   : manufacturer
    Created on : Jun 13, 2017, 10:08:27 AM
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
		<td><h1 align="center">${applicationScope.MANUFACTURERS}</h1></td>
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
			    <th>${applicationScope.manufacturer}</th>
			    <th colspan="2">${applicationScope.edit}</th>
			</tr>
			<c:forEach items="${requestScope.listManufacturers}" var="manuf">
			    <tr>
			    <form action="/CarRental/Web" method="POST">
				<td><input type="text" name="idManufacturer" value="${manuf.id}"></td>
				<td><input type="text" name="manufacturer" value="${manuf.manufacturer}"></td>
				<td colspan="2">
				    <input type="hidden" name="selectedManufacturerId" value="${manuf.id}">
				    <input type="hidden" name="cmd" value="editManufacturer">
				    <input type="submit" name="action" value="${applicationScope.edit}">
				    <input type="submit" name="action" value="${applicationScope.delete}">
				    <input type="reset" value="${applicationScope.reset}" >
				</td>
			    </form>
		</tr>
	    </c:forEach>
	    <tr>
	    <form action="/CarRental/Web" method="POST">
		<td><input type="text" name="idManufacturer" value="test"></td>
		<td><input type="text" name="manufacturer" value="test"></td>
		<td><input type="reset" value="${applicationScope.reset}" ></td>
		<td>
		    <input type="submit" value="${applicationScope.addition}">
		    <input type="hidden" name="cmd" value="addManufacturer">
		</td>
	    </form>
	</tr>
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
