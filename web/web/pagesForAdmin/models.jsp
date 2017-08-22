<%-- 
    Document   : models
    Created on : Jun 13, 2017, 10:00:05 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<td><h1 align="center">${applicationScope.MODELS}</h1></td>
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
			    <th>${applicationScope.color}</th>
			    <th>${applicationScope.transmission}</th>
			    <th>${applicationScope.bodyType}</th>
			    <th>${applicationScope.power}</th>
			    <th colspan="2">${applicationScope.edit}</th>
			</tr>
			<c:forEach items="${requestScope.listModels}" var="model">
			    <tr>
			    <form action="/CarRental/Web" method="POST">
				<td><input type="text" name="idModel" value="${model.id}"></td>
				<td><input type="text" name="color" value="${model.color}"></td>
				<td><input type="text" name="transmission" value="${model.transmission}"></td>
				<td><input type="text" name="bodyType" value="${model.bodyType}"></td>
				<td><input type="text" name="power" value="${model.power}"></td>
				<td colspan="2">
				    <input type="hidden" name="selectedModelId" value="${model.id}">
				    <input type="hidden" name="cmd" value="editModel">
				    <input type="submit" name="action" value="${applicationScope.edit}">
				    <input type="submit" name="action" value="${applicationScope.delete}">
				    <input type="reset" value="${applicationScope.reset}" >
				</td>
			    </form>
		</tr>
	    </c:forEach>
	    <tr>
	    <form action="/CarRental/Web" method="POST">
		<td><input type="text" name="idModel" value="test"></td>
		<td><input type="text" name="color" value="test"></td>
		<td><input type="text" name="transmission" value="test"></td>
		<td><input type="text" name="bodyType" value="test"></td>
		<td><input type="text" name="power" value="test"></td>
		<td><input type="reset" value="${applicationScope.reset}" ></td>
		<td>
		    <input type="submit" value="${applicationScope.addition}">
		    <input type="hidden" name="cmd" value="addModel">
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
