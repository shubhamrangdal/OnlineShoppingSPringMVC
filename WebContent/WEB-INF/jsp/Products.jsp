<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
     <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
<h3>Products</h3>
	<form:form method="post"  commandName="products" action="/OnlineShoppingApplicationSpring/addtoCart" >
		<c:forEach items="${map1}" var="mapvar">
            <tr>
                <td><form:checkbox path="list" value="${mapvar.key}"  /></td>
                <td><c:out value="${mapvar.key} " /><br><br></td>
            </tr>
        </c:forEach>
        <input type="submit" value="Add To Cart" onclick="/OnlineShoppingApplicationSpring/addtoCart">
         
 </form:form>

</body>
</html>