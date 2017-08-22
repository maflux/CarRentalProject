<%-- 
    Document   : header
    Created on : Jun 11, 2017, 5:15:50 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--<img src="Images\ephemeral_header02.jpg" alt="Image" width="100%" height="100%"/>-->
	<table border="0" align="center" width="95%" height="95%" background="http://localhost:8084/CarRental/Images/ephemeral_header02.jpg">
	    <tr align="center">
		<td rowspan="2" width="5%">
		    ${applicationScope.totalUsers} : ${applicationScope.countGuest}
		    <p>
		    <form action="/CarRental/Web" method="GET">
			<input type="hidden" name="cmd" value="languageRU">
			<input type="submit" value="${applicationScope.languageRU}">
		    </form>

		    <form action="/CarRental/Web" method="GET">
			<input type="hidden" name="cmd" value="languageENG">
			<input type="submit" value="${applicationScope.languageENG}">
		    </form>
			    <!--<a href="">${applicationScope.languageRU}</a>-->
			    <!--<a href="">${applicationScope.languageENG}</a>-->
		    <!--			    <select size="1" name="language" width="20">
						    <option value="Eng">English</option>
						    <option value="Ru">Russian</option>
						</select>-->
		    </p>
		</td> 
		<td><center><h1>${applicationScope.carRental}</h1></center></td>
	<td rowspan="2" width="5%">
	    <form action="/CarRental/Web" method="post">
		<table width="100%" border="5" cellspacing="3" cellpadding="1">
		    <tr>
			<td> <p><b>${applicationScope.login}</b></p> </td>
			<td> <p><b>${applicationScope.password}</b></p> </td>
		    </tr>
		    <tr>
		    <input type="hidden" name="cmd" value="sign_in">
		    <td> 
			<input type="text" name="login" value=""> </td>
		    <td> <input type="password" name="password" value="*****"> </td>
		    </tr>
		    <tr>
			<td align="center"> <input type="submit" value="${applicationScope.signIn}"> </td>
			<td align="center"> <a href="http://localhost:8084/CarRental/web/createAccount.jsp">${applicationScope.createAccount}</a> </td>
		    </tr>
		</table>
	    </form>
	</td>
    </tr>
    <tr>
	<td>
	    <table>
		<tr>
		    <td>
			<a href="http://localhost:8084/CarRental/"> <input type="button" value="${applicationScope.startPage}"/></a>
		    </td>
		    <td>
			<form action="/CarRental/Web" method="POST">
			    <input type="hidden" name="cmd" value="cars"/>
			    <input type="submit" value="${applicationScope.parkCars}"/>
			</form>
		    </td>
		</tr>
	    </table>
	</td>
    </tr>

</table>


</table>
</body>
</html>
