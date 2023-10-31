<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Home!</h1>
        <ul>
            <c:forEach items="${categoryList}" var="c" >         
                <li><a href="service?categoryId=${c.getCategoryId()}">${c.getCategoryName()}</a></li>        
                </c:forEach>
        </ul>
    </body>
</html>
