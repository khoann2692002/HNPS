<%-- 
    Document   : DetailsServivce
    Created on : Oct 26, 2023, 2:45:31 PM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${service.getServiceName()}</h1>
        
        <h4>${service.description}</h4>
    </body>
</html>
