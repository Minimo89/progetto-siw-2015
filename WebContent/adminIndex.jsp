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
<h1>Profilo di ${adminController.admin.username } (Admin)</h1>
<h:form>
<div><a href="<c:url value="/faces/newProduct.jsp"/>">Inserisci prodotto</a></div>
<div><a href="<c:url value="/faces/newProvider.jsp"/>">Inserisci provider</a></div>
<div><h:commandLink value = "Visualizza Ordini" action="#{orderController.getAllOrders }"/> </div>
<div><h:commandLink value = "Ordini non evasi" action="#{orderController.findOrdersToBeFilled }"/> </div>
<div><h:commandLink value = "Prodotti" action="#{productController.getAllProductsAdmin}"/> </div>
<div>
		<h:commandButton value = "Logout" action = "#{adminController.logOut }"/>
</div>
</h:form>
</f:view>
</body>
</html>