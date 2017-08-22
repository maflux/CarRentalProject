<%-- 
    Document   : AboutUs
    Created on : Aug 9, 2017, 10:36:39 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${applicationScope.footerAboutUs}</title>
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
	<h1 align="center">WE ARE THE BEST IN THE WORLD... MAY BE =))))</h1>
    </body>
</html>

<%@include file="../footer.jsp" %>