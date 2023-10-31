<%-- 
    Document   : ServiceList
    Created on : Oct 26, 2023, 1:15:06 PM
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
        <h1>Danh sach cac service</h1>

        <c:if test="${sessionScope.user == null && sessionScope.user2 == null}">
            <h1>Vui lòng đăng nhập để sử dụng các dịch vụ</h1>
        </c:if>

        <c:if test="${sessionScope.user != null || sessionScope.user2 != null}">




            <form method="post" action="searchservice">
                <input name="servicename" type="text" >
                <input name="categoryId" type="hidden" value="${categoryId}">
                <button type="submit">Tìm kiếm</button>
            </form>


            <c:if test="${serviceList!= null}">
                <ul>
                    <c:forEach items="${serviceList}" var="c" >         
                        <li><a href="detailsservice?serviceId=${c.getServiceId()}">${c.getServiceName()}</a></li>        
                        </c:forEach>
                </ul>
            </c:if>   
            <c:if test="${serviceList.size()==0}">
                <h1>Không có kết quả cho từ khóa tìm kiếm của bạn</h1>
            </c:if>           
        </c:if>
    </body>
</html>
