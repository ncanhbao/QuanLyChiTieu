<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>

<div class="container">
    <h1 class="text-center text-primary mt-5">Đăng nhập</h1>
    <c:url value="/login" var="action" />
    <form method="post" action="${action}" class="form-group mt-3">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <input type="text" id="username" name="username" class="form-control" />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password" class="form-control" />
        </div>
        <div class="mb-3"></div> <!-- Add this line to create more space -->
        <c:if test="${param.error != null}">
            <div class="text-danger">
                Vui lòng nhập thông tin chính xác!
            </div>
        </c:if>
        <div class="form-group">
            <input type="submit" value="Đăng nhập" class="btn btn-primary" />
        </div>
    </form>
    <div class="text-center mt-3">
        <p>Bạn chưa có tài khoản, hãy <a href="<c:url value="/register" />">đăng ký</a>.</p>
    </div>
</div>
