<%-- 
    Document   : signIn
    Created on : Jun 12, 2017, 1:03:25 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${applicationScope.createAccount}</title>
	<!--Choise header-->
	<c:if test="${sessionScope.header eq null}" >
	    <jsp:include page="../header.jsp"></jsp:include>
	</c:if>
	<c:if test="${sessionScope.header ne null}" >
	    <jsp:include page="../${sessionScope.header}"></jsp:include>
	</c:if>
    </head>
    <body>
        <table align="center" border="0" width="90%" height="90%">

	    <tr>
		<td>
		    <!--1-->
		</td>
		<td><h1 align="center">${applicationScope.createAccount}</h1></td>
		<td>
		    <!--1-->
		</td>
	    </tr>
	    <tr>
		<td>1</td>
		<td>
		    <form action="/CarRental/Web" method="POST">
			<table align="center" width="" border="1" cellspacing="2" cellpadding="2">
			    <tr>
				<td>${applicationScope.login}: *</td>
				<td><input type="text" name="login" value="" required></td>
			    </tr>
			    <tr>
				<td>${applicationScope.password}: *</td>
				<td><input type="password" name="password" value="" required></td>
			    </tr>
			    <tr>
				<td>${applicationScope.firstName}: *</td>
				<td><input type="text" name="first_name" value="" required></td>
			    </tr>
			    <tr>
				<td>${applicationScope.lastName}: *</td>
				<td><input type="text" name="last_name" value="" required></td>
			    </tr>
			    <tr>
				<td>${applicationScope.fatherName}:</td>
				<td><input type="text" name="father_name" value=""></td>
			    </tr>
			    <tr>
				<td>${applicationScope.numberPhone}: *</td>
				<td><input type="text" name="number_phone" value="" required></td>
			    </tr>
			    <tr>
				<td>${applicationScope.email}:</td>
				<td><input type="text" name="email" value=""></td>
			    </tr>
			    <tr>
				<td>${applicationScope.passport}: *</td>
				<td><input type="text" name="passport" value="" required></td>
			    </tr>
			    <tr>
				<td align="center" colspan="2"> 
				    <input type="hidden" name="cmd" value="createAccount"> 
				    <input type="submit" value="${applicationScope.createAccount}"> 
				</td>
			    </tr>
			</table>
		    </form>
	    <center>* - ${applicationScope.canNotBeEmpty}</center>

	</td>
	<td>
	    <!--1-->
	</td>
    </tr>
    <tr>
	<td>
	    <!--21-->
	</td>
	<td>
	    <!--22-->
	</td>
	<td>
	    <!--23-->
	</td>
    </tr>

</table>
</body>
</html>

<%@include file="../footer.jsp" %>