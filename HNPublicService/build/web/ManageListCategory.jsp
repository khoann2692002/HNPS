<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit Category</title>
    </head>
    <body>
        <h1>Hello World!</h1>


        <table border="1">
            <thead>
            <td>CategoryId</td>
            <td>Category Name</td>
            <td>mô tả</td>
            <td>trạng thái</td>
            <td>Chỉnh sửa</td>
        </thead>
        <c:forEach items="${categoryList}" var="c" >         
            <tr>
                <td>${c.categoryId}</td>
                <td>${c.categoryName}</td>
                <td>${c.description}</td>
                <td>${c.status}</td>
                <td><a href="editcategory?categoryId=${c.categoryId}"> Edit</a></td>
            </tr>   
        </c:forEach>

    </table>

</body>
</html>
