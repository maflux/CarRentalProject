<%-- 
    Document   : PrivacyPolicy
    Created on : Aug 9, 2017, 10:34:10 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${applicationScope.footerPrivacyPolicy}</title>
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
	<p>
	    Файлы Cookie.
	    Сайт Car Rental ограниченно использует файлы cookie для предоставления лучшего 
	    обслуживания. Однако мы не храним в данных файлах личную информацию или данные 
	    вашей кредитной карты.В данных файлах хранится ID номер сессии.

	</p>
    </body>
</html>

<%@include file="../footer.jsp" %>
