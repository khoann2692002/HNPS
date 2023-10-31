<%-- 
    Document   : EditCategory
    Created on : Oct 26, 2023, 9:22:52 PM
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
        <h1>Edit category!</h1>

        <form action="editcategory" method="post">
            <table border="1">
                <thead>
                <td>CategoryId</td>
                <td>Category Name</td>
                <td>mô tả</td>
                <td>trạng thái</td>
                <td>Chỉnh sửa</td>
                </thead>
                <tr>
                    <td><input type="text " value="${c.categoryId}" name="categoryId" readonly></td>
                    <td> <input type="text " value=" ${c.categoryName}" name="categoryName" required> </td>
                    <td><input type="text " value="${c.description}" name="description" required> </td>
                    <td><input type="text " value="${c.status}" name="status" required></td>
                    <td><Button type="submit">Lưu</Button></td>
                </tr>


            </table>
    </body>
</html>
