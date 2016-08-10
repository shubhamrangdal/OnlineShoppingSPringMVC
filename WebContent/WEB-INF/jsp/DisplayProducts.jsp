<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
     <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Cart Items </h3>
	<form:form   commandName="products"  method="post" action="/OnlineShoppingApplicationSpring/deleteFromCart" >
		<c:forEach items="${map}" var="mapvar"><%-- ${mapvar} <br /> --%>
			<tr>
                <td><form:checkbox path="list" value="${mapvar}"  /></td>
                <td><c:out value="${mapvar.key}  ${mapvar }" /><br><br></td>
            </tr>	
		</c:forEach>
		<form:errors path="list" cssClass="error" />
		
		<input type="submit" value="delete from cart" onclick="/OnlineShoppingApplicationSpring/deleteFromCart">
	</form:form>
	
	<form:form commandName="products"  method="get" action="/OnlineShoppingApplicationSpring/success" >
		<input type="submit" value="Add to cart" >
	</form:form> 
	
	<form:form commandName="products"  method="post" action="/OnlineShoppingApplicationSpring/placeOrder" >
		<input type="submit" value="Place Order" onclick="/OnlineShoppingApplicationSpring/placeOrder">
	</form:form>
</body>
</html>