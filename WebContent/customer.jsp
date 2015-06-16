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
<h1>${orderController.customer.firstName } ${orderController.customer.lastName }</h1>
<h2>Indirizzo:</h2>
	<div>Via: ${orderController.customer.address.street }</div>
	<div>Città: ${orderController.customer.address.city }</div>
	<div>Regione: ${orderController.customer.address.country }</div>
	<div>Nazione: ${orderController.customer.address.state }</div>
	<div>CAP: ${orderController.customer.address.zipcode }</div>
<h:form>
<div><h:commandLink value = "Torna agli Ordini" action="#{orderController.getAllOrders }"/> </div>
</h:form>
<div><a href="<c:url value="/faces/adminIndex.jsp"/>">Home</a></div>
</f:view>
</body>
</html>