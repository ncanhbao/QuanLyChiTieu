<%-- 
    Document   : addUser
    Created on : Jun 12, 2024, 10:21:27 PM
    Author     : ncanh
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>

<div class="container">
    <h1 class="text-center text-primary mt-5">Đăng ký</h1>
    <c:url value="/register" var="action" />
    <form:form method="post" action="${action}" modelAttribute="user" class="form-group mt-3">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <form:input path="username" class="form-control" id="username" placeholder="Username" />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <form:input path="password" class="form-control" id="password" placeholder="Password" type="password" />
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <form:input path="name" class="form-control" id="name" placeholder="Name" />
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Phone Number</label>
            <form:input path="phone" class="form-control" id="phone" placeholder="Phone Number" />
        </div>
        <div class="mb-3">
            <label for="avatar" class="form-label">Avatar URL</label>
            <form:input path="avatar" class="form-control" id="avatar" placeholder="Avatar URL" />
        </div>
        <button type="submit" class="btn btn-primary">Đăng ký</button>
    </form:form>

    <c:if test="${not empty success}">
        <div class="alert alert-success mt-3">${success}</div>
    </c:if>

    <c:if test="${not empty error}">
        <div class="alert alert-danger mt-3">${error}</div>
    </c:if>
</div>
