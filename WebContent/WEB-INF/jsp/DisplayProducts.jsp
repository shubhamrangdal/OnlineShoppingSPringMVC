<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
     <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Display Product</h3>
	<form:form method="get"  commandName="products"   >
		<c:forEach items="${map}" var="mapvar"><%-- ${mapvar} <br /> --%>
			<tr>
                <td><form:checkbox path="map" value="${mapvar}"  /></td>
                <td><c:out value="${mapvar}" /><br><br></td>
            </tr>	
		</c:forEach>
		<input type="submit" value="Add to Cart">
		<input type="submit" value="delete from cart">
	</form:form>
</body>
</html>