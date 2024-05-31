<%-- 
    Document   : header
    Created on : May 30, 2024, 2:32:33 PM
    Author     : ncanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Quản lý chi tiêu</a>
        </div>
        <ul class="navbar-nav me-auto">
            <li class="active nav-item"><a href="#" class="nav-link">Tổng quan</a></li>
            <li><a class="nav-link" href="#">Sổ giao dịch</a></li>
            <li><a class="nav-link" href="#">Báo cáo</a></li>
            <li><a class="nav-link" href="#">Nhóm</a></li>
            <li><a class="nav-link" href="#">Tài khoản</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li>
                    <a href="<c:url value="/login" />" class="btn btn-outline-light">Đăng nhập</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li>
                    <a href="#" class="btn btn-outline-light">${pageContext.request.userPrincipal.name}</a>
                </li>
                <li>
                    <a href="<c:url value="/logout" />" class="btn btn-outline-light">Đăng xuất</a>
                </li>
            </c:if>
        </ul>    
    </div>
</nav>