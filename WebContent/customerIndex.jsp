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
<h1>Profilo di ${customerController.customer.firstName} ${customerController.customer.lastName}</h1>
<h:form>
<div>
		<div><h:commandLink value="Listino" action="#{productController.getAllProductsCustomer }"/></div>
		<h:commandButton value="Carrello" action="#{orderController.getCurrentOrder }">
			<f:param name="customerId" value="#{customerController.id }"/>
			</h:commandButton>
		<h:commandButton value = "Logout" action = "#{customerController.logOut}"/>
</div>
</h:form>
</f:view>
</body>
</html>