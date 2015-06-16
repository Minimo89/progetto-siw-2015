<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
<h:form>
<table>
	<thead>
		<tr>
			<td> ID Ordine</td>
			<td> Data chiusura</td>
			<td> Data evasione</td>
	</thead>
	<tbody>
	<c:forEach var="order" items="#{orderController.orders }">
		<tr>
			<td>${order.id }</td>
			<td>${order.closeDate }</td>
			<td>${order.evasionDate }</td>
			<td>
				<h:commandButton value = "Dettagli" action = "#{orderController.findOrder }">
						<f:param name="id" value="#{order.id }"/>
				</h:commandButton>
		</tr>
	</c:forEach>
	</tbody>
</table>

<div><a href="<c:url value="/faces/customerIndex.jsp"/>">Home</a></div>
</h:form>
</f:view>
</body>
</html>