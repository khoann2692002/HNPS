<%-- 
    Document   : Admin
    Created on : Oct 19, 2023, 8:24:06 PM
    Author     : Nguyen Nguyen Khoa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://kit.fontawesome.com/3098a9fa7b.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" 
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">        
        <title>Admin Control</title>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="js/resizableColumns.min.js"></script>
        <link rel="stylesheet" href="Admin.css"/>
        <!--<link rel="shortcut icon" href="./img/ODB_ Online_Debt_Book.png" type="image/x-icon">-->


    </head>
    <body>
        <c:if  test="${sessionScope.user2.isAdmin==true || sessionScope.user.isAdmin==true}">
            <div class="box">          
                <h1>User's Information</h1>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Username</th>
                            <th scope="col">Email</th>
                            <th scope="col">Phone</th>
                            <th scope="col">Address</th>
                            <th scope="col">Status</th>
                            <th scope="col">Change Status</th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="o" items="${listUserInfo}">
                            <tr>
                                <td>${o.accountID}</td>
                                <td>${o.accountName}</td>
                                <td>${o.email}</td>
                                <td>${o.phone}</td>
                                <td>${o.address}</td>
                                <td>${o.isActive?"Active":"De Active"}</td>
                                <c:if test="${o.isActive}">
                                    <td><a href="changeActive?uEmail=${o.email}&status=0" onclick="showmess()" class="btn btn-warning">De Active</a></td>
                                </c:if>
                                <c:if test="${!o.isActive}">
                                    <td><a href="changeActive?uEmail=${o.email}&status=1" onclick="showmess()" class="btn btn-success">Active</a></td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>

    </body>
    <script>
        function showmess() {
            var option = confirm("Are you sure to change status of Account ?");
            if (option === true) {
                return true;
            } else {
                return false;
            }
        }
    </script>
</html>
