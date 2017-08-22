<%-- 
    Document   : index
    Created on : Jun 11, 2017, 6:27:15 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${applicationScope.startPage}</title>
	<!--Choise header-->
	<c:if test="${sessionScope.header eq null}" >
	    <jsp:include page="header.jsp"></jsp:include>
	    <%--<jsp:include page="web/header/headerAdmin.jsp"></jsp:include>--%>
	</c:if>
	<c:if test="${sessionScope.header ne null}" >
	    <%--<jsp:include page="web/header/headerAdmin.jsp"></jsp:include>--%>
	    <jsp:include page="${sessionScope.header}"></jsp:include>
	</c:if>

    </head>
    <body>
	<table align="center" border="0" width="90%" height="90%">

	    <tr>
		<td>
		    <!--11-->
		</td>
		<td>
		    <!--12-->
		</td>
		<td>
		    <!--13-->
		</td>
	    </tr>
	    <tr>
		<td>
		    <!--21-->
		</td>
		<td>
		    <h3>
			<p>


			    Дешевая Аренда Авто
			    большой выбор и непревзойденные цены


			</p>
		    </h3>
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
		    <!--32-->
		</td>
		<td>
		    <!--33-->
		</td>
	    </tr>

	</table>
    </body>
</html>

<%@include file="footer.jsp" %>