<%-- 
    Document   : headerAdmin
    Created on : Jun 12, 2017, 3:28:34 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--<img src="Images\ephemeral_header02.jpg" alt="Image" width="100%" height="100%"/>-->
	<table border="5" align="center" width="95%" height="95%" background="http://localhost:8084/CarRental/Images/ephemeral_header02.jpg">
	    <tr align="center">
		<td rowspan="2" width="5%">
		    ${applicationScope.totalUsers}: ${applicationScope.countGuest}
		    <p>
		    <form action="/CarRental/Web" method="GET">
			<input type="hidden" name="cmd" value="languageRU">
			<input type="submit" value="${applicationScope.languageRU}">
		    </form>

		    <form action="/CarRental/Web" method="GET">
			<input type="hidden" name="cmd" value="languageENG">
			<input type="submit" value="${applicationScope.languageENG}">
		    </form>
		</td> 
		<td><center><h1>${applicationScope.carRental}</h1></center></td>
	<td rowspan="2" width="5%">
	    <table width="100%" border="5" cellspacing="3" cellpadding="1">
		<tr>
		    <td> <p><b>${applicationScope.login}</b></p> </td>
		    <td> <p><b>${applicationScope.password}</b></p> </td>
		</tr>
		<tr>
		    <td> ${applicationScope.administrator} </td>
		    <td> ${applicationScope.administrator} </td>
		</tr>
		<tr>
		    <td align="center"> ${applicationScope.administrator} </td>
		    <td align="center"> 
			<form action="/CarRental/Web" method="GET"> 
			    <input type="hidden" name="cmd" value="sign_out"/>
			    <input type="submit" value="${applicationScope.signOut}"> 
			</form>
		    </td>
		</tr>
	    </table>
	</td>
    </tr>
    <tr>
	<td>
	    <table width="100%">
		<tr>
		    <td align="center">
			<a href="http://localhost:8084/CarRental/"> <input type="button" value="${applicationScope.startPage}"/></a>
		    </td>
		    <td align="center">
			<form action="/CarRental/Web" method="POST">
			    <input type="hidden" name="cmd" value="cars"/>
			    <input type="submit" value="${applicationScope.parkCars}"/>
			</form>
		    </td>
		    <td align="center">
			<form action="/CarRental/Web" method="POST">
			    <input type="hidden" name="cmd" value="models"/>
			    <input type="submit" value="${applicationScope.allModels}"/>
			</form>
		    </td>
		    <td align="center">
			<form action="/CarRental/Web" method="POST">
			    <input type="hidden" name="cmd" value="manufacturers"/>
			    <input type="submit" value="${applicationScope.allManufacturers}"/>
			</form>
		    </td>
		<tr>
		    <td align="center">
			<form action="/CarRental/Web" method="POST">
			    <input type="hidden" name="cmd" value="orders"/>
			    <input type="submit" value="${applicationScope.allOrders}"/>
			</form>
		    </td>
		    <td align="center">
			<form action="/CarRental/Web" method="POST">
			    <input type="hidden" name="cmd" value="clients"/>
			    <input type="submit" value="${applicationScope.allClients}"/>
			</form>
		    </td>
		    <td align="center">
			<form action="/CarRental/Web" method="POST">
			    <input type="hidden" name="cmd" value="users"/>
			    <input type="submit" value="${applicationScope.allUsers}"/>
			</form>
		    </td>
		    <td align="center">
			<form action="/CarRental/Web" method="POST">
			    <input type="hidden" name="cmd" value="roles"/>
			    <input type="submit" value="${applicationScope.allRoles}"/>
			</form>
		    </td>
		</tr>
    </tr>
</table>
</td>
</tr>

</table>


</table>
</body>
</html>

