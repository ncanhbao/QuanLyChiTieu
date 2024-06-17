<%-- 
    Document   : home
    Created on : May 31, 2024, 2:31:51 PM
    Author     : ncanh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hệ thống quản lý chi tiêu</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container my-5">
            <h1 class="text-center mb-4">Chào mừng đến với Hệ thống quản lý chi tiêu</h1>
            <p class="lead">
                Quản lý chi tiêu của bạn một cách hiệu quả và tiết kiệm với công cụ quản lý chi phí mạnh mẽ của chúng tôi.</p>
            <div class="d-flex justify-content-center mt-4">
                <a href="<c:url value="/login" />" class="btn btn-primary btn-lg mx-2">Đăng nhập</a>
                <a href="<c:url value="/register" />" class="btn btn-outline-primary btn-lg mx-2">Đăng ký</a>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
