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
		<th>Nome</th>
		<th>Prezzo</th>
		<th>Quantita</th>
		<th></th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="orderLine" items="#{orderController.orderLines }">
		<tr>
			<td>${orderLine.product.name }</td>
			<td>${orderLine.product.price }</td>
			<td>${orderLine.quantity }
		</tr>
	</c:forEach>
	</tbody>
	</table>
	
	Totale: ${orderController.total }
	
	<h:commandButton value="Conferma ordine" action="#{orderController.validateOrder }">
		<f:param name="customerId" value="#{customerController.id }"/>
	</h:commandButton>
	
	
	<div><a href="<c:url value="/faces/customerIndex.jsp"/>">Home</a></div>
</h:form>

</f:view>
</body>
</html>