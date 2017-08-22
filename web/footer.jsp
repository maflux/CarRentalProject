<%-- 
    Document   : footer
    Created on : Aug 9, 2017, 10:19:02 PM
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
	<!--	<div>TODO write content</div>-->

	<table border="0" align="center" width="95%" height="95%" background="http://localhost:8084/CarRental/Images/ephemeral_header02.jpg">
	    <tr align="center">
		<td rowspan="2" width="200">
		    <img width="95%" height="95%" src="http://localhost:8084/CarRental/Images/Subaru_Impreza_WRC_pic_94445.jpg" alt="SubaruPhoto">
		</td> 
		<td> 
		    <a href="http://localhost:8084/CarRental/PrivacyPolicy.jsp">${applicationScope.footerPrivacyPolicy}</a> 
		</td>
		<td rowspan="2" width="200"> 
		    <a href="http://localhost:8084/CarRental/AboutUs.jsp">${applicationScope.footerAboutUs}</a> 
		</td>
	    </tr>
	    <tr align="center">
		<td>
		    <a href="http://localhost:8084/CarRental/TermsOfUse.jsp">${applicationScope.footerTermsOfUse}</a> 
		</td>
	    </tr>

	</table>
    </body>
</html>
