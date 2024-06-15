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
            <li class="active nav-item"><a href="<c:url value="/home" />" class="nav-link">Tổng quan</a></li>
            <li><a class="nav-link" href="<c:url value="/transactions" />">Sổ giao dịch</a></li>
            <li><a class="nav-link" href="#">Báo cáo</a></li>
            <li><a class="nav-link" href="#">Nhóm</a></li>
            <li><a class="nav-link" href="#">Tài khoản</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <c:if test="${pageContext.request.userPrincipal.name == null}">
                <li>
                    <a href="<c:url value="/login" />" class="btn btn-outline-light">Đăng nhập</a>
                </li>
                <li class="mx-2">
                    <a href="<c:url value="/register" />" class="btn btn-outline-light">Đăng ký</a>
                </li>
            </c:if>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <li>
                    <h4 style="color: white; padding-top: 5px;">Xin chào  ${pageContext.request.userPrincipal.name} !</h4>
                </li>
                <li class="mx-2">
                    <a href="<c:url value="/logout" />" class="btn btn-outline-light">Đăng xuất</a>
                </li>
            </c:if>
        </ul>    
    </div>
</nav>