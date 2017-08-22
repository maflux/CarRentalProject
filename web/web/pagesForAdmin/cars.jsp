<%-- 
    Document   : cars
    Created on : Jun 12, 2017, 12:05:54 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="by.course.abramian.dal.entitydto.Car" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${applicationScope.parkCars}</title>
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
		<td><h1 align="center">${applicationScope.CARS}</h1></td>
		<td>
		    <!--13-->
		</td>
	    </tr>
	    <tr>
		<td>
		    <!--1-->
		</td>
		<td>
		    <table align="center" border="1">
			<tr>
			    <th>№</th>
			    <th>${applicationScope.manufacturer}</th>
				<c:if test="${applicationScope.roleAdmin eq true}">
				<th>
				    ${applicationScope.model}
				</th>
			    </c:if>
			    <th>${applicationScope.color}</th>
			    <th>${applicationScope.transmission}</th>
			    <th>${applicationScope.bodyType}</th>
			    <th>${applicationScope.power}</th>
			    <th>${applicationScope.free}</th>
				<c:if test="${sessionScope.checkSignIn eq true}">
				<th>${applicationScope.choice}</th>
				</c:if>
				<c:if test="${applicationScope.roleAdmin eq true}">
				<th colspan="3">${applicationScope.edit}</th>
				</c:if>
			</tr>
			<c:forEach items="${requestScope.listCars}" var="car">
			    <tr>
			    <form action="/CarRental/Web" method="POST">

				<td><input type="text" name="idCar"  value="${car.id}"></td>
				<td>
				    <!--<input type="text" name="manufacturer" value="${car.manufacturer.manufacturer}">-->
				    <c:if test="${applicationScope.roleAdmin eq true}">

					<select size="1" name="carIdManufacturer">
					    <option value="${car.manufacturer.id}">${car.manufacturer.manufacturer}</option>
					    <c:forEach items="${requestScope.listManufacturers}" var="manuf">
						<option value="${manuf.id}">${manuf.manufacturer}</option>
					    </c:forEach> 
					</select>
				    </c:if>
				    <c:if test="${applicationScope.roleAdmin eq false}">
					${car.manufacturer.manufacturer}
				    </c:if>
				</td>
				<c:if test="${applicationScope.roleAdmin eq true}">
				    <td>
					<select size="1" name="carIdModel">
					    <option value="${car.model.id}">
						${car.model.id} -
						${car.model.color} -
						${car.model.transmission} -
						${car.model.bodyType} -
						${car.model.power}.
					    </option>

					    <c:forEach items="${requestScope.listModels}" var="model">
						<option value="${model.id}">
						    ${model.id} -
						    ${model.color} -
						    ${model.transmission} -
						    ${model.bodyType} -
						    ${model.power}.
						</option>
					    </c:forEach> 
					</select>
				    </td>
				</c:if>
				<td><input type="text" name="color" value="${car.model.color}"></td>
				<td><input type="text" name="transmission" value="${car.model.transmission}"></td>
				<td><input type="text" name="bodyType" value="${car.model.bodyType}"></td>
				<td><input type="text" name="power" value="${car.model.power}"></td>
				<td><input type="text" name="free" value="${car.free}"></td>
				    <c:if test="${sessionScope.checkSignIn eq true}">
				    <td>
					<c:if test="${car.free eq true}">
					    <form id="form" action="/CarRental/Web" method="POST">
						<input type="hidden" name="selectedIdCar" value="${car.id}">
						<input type="hidden" name="cmd" value="choiceCar">
						<input type="submit" value="${applicationScope.choose}">
					    </form>
					</c:if>
				    </td>
				</c:if>
				<c:if test="${applicationScope.roleAdmin eq true}">
				    <td>
					<input type="hidden" name="selectedIdCar" value="${car.id}">
					<input type="hidden" name="cmd" value="editCar">
					<input type="submit" name="action" value="${applicationScope.edit}">
				    </td>
				    <td>
					<input type="submit" name="action" value="${applicationScope.delete}">
				    </td>
				    <td>
					<input type="reset" value="${applicationScope.reset}">
				    </td>
				</c:if>
			    </form>
		</tr>
	    </c:forEach>
	    <c:if test="${applicationScope.roleAdmin eq true}">
		<tr>
		<form action="/CarRental/Web" method="POST">
		    <td><input type="text" name="idCar"  value="${car.id}"></td>
		    <td>
			<!--<input type="text" name="manufacturer" value="${car.manufacturer.manufacturer}">-->
			<select size="1" name="carIdManufacturer">
			    <option value="${car.manufacturer.id}">${car.manufacturer.manufacturer}</option>
			    <c:forEach items="${requestScope.listManufacturers}" var="manuf">
				<option value="${manuf.id}">${manuf.manufacturer}</option>
			    </c:forEach> 
			</select>
		    </td>
		    <td>
			<select size="1" name="carIdModel">
			    <option value="${car.model.id}">
				${car.model.id} -
				${car.model.color} -
				${car.model.transmission} -
				${car.model.bodyType} -
				${car.model.power}.
			    </option>
			    <c:forEach items="${requestScope.listModels}" var="model">
				<option value="${model.id}">
				    ${model.id} -
				    ${model.color} -
				    ${model.transmission} -
				    ${model.bodyType} -
				    ${model.power}.
				</option>
			    </c:forEach> 
			</select>
		    </td>
		    <td></td>
		    <td></td>
		    <td></td>
		    <td></td>
		    <td></td>
		    <td></td>
		    <td colspan="2"><input type="reset" value="${applicationScope.reset}" ></td>
		    <td>
			<input type="submit" value="${applicationScope.addition}">
			<input type="hidden" name="cmd" value="addCar">
		    </td>
		    </td>

		</form>
	    </tr>
	</c:if>
    </table>

</td>
<td>
    <!--1-->
</td>
</tr>
<tr>
    <td>
	<!--3-->
    </td>
    <td align="center">
	<c:if test="${sessionScope.checkSignIn eq true}">
	    <b>${applicationScope.dateOfBegining}:*</b>
	    <input type="datetime-local" name="dateOfBegining" value="${applicationScope.menuDate}" form="form" required>
	    <b>${applicationScope.dateOfEnding}:*</b>
	    <input type="datetime-local"  name="dateOfEnding" value="${applicationScope.menuDate}" form="form" required>
	    <input type="reset" value="${applicationScope.reset}" form="form">
    <center>* - ${applicationScope.canNotBeEmpty}</center>
    </c:if>
    ${applicationScope.yourRegistration} - ${sessionScope.checkSignIn}
</td>
<td>
    <!--33-->
</td>
</tr>
</table>
</body>
</html>

<%@include file="../../footer.jsp" %>
