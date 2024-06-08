<%-- 
    Document   : login
    Created on : Jun 2, 2024, 2:27:36 PM
    Author     : ncanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">ĐĂNG NHẬP</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Đã có lỗi xảy ra! Vui lòng quay lại sau!
    </div>
</c:if>

<c:url value="/login" var="action" />
<form method="post" action="${action}">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control"/>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="text" id="password" name="password" class="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Đăng nhập" class="btn btn-danger"/>
    </div>
</form>