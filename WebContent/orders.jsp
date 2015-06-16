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
				<td>ID Ordine</td>
				<td>ID Cliente</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="order" items="#{orderController.orders }">
				<tr>
					<td>${order.id }</td>
					<td>${order.customer.id }</td>
					<td><h:commandLink value="Dettagli cliente" action="#{orderController.findCustomer }">
							<f:param name="id" value="#{order.id }"/>
					</h:commandLink> </td>
					
			</c:forEach>
		</tbody>
	</table>
	
	<div><a href="<c:url value="/faces/adminIndex.jsp"/>">Home</a></div>
</h:form>

</f:view>
</body>
</html>