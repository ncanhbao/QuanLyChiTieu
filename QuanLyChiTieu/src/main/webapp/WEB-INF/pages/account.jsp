<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <h1 class="text-center text-primary mt-5">Thông tin tài khoản</h1>
    <c:url value="/account" var="action" />
    <form:form method="post" action="${action}" modelAttribute="user" class="form-group mt-3">
        <div class="mb-3">
            <label for="username" class="form-label">Username</label>
            <form:input path="username" class="form-control" id="username" placeholder="Username" readonly="true" autocomplete="off" />
        </div>
        <div class="mb-3">
            <label for="name" class="form-label">Tên</label>
            <form:input path="name" class="form-control" id="name" placeholder="Tên" autocomplete="off" />
        </div>
        <div class="mb-3">
            <label for="phone" class="form-label">Số điện thoại</label>
            <form:input path="phone" class="form-control" id="phone" placeholder="Số điện thoại" autocomplete="off" />
        </div>
        <div class="mb-3">
            <label for="avatar" class="form-label">URL Ảnh đại diện</label>
            <form:input path="avatar" class="form-control" id="avatar" placeholder="URL Ảnh đại diện" autocomplete="off" />
        </div>
        <button type="submit" class="btn btn-primary">Cập nhật thông tin</button>
    </form:form>

    <c:if test="${not empty success}">
        <div class="alert alert-success mt-3">${success}</div>
    </c:if>

    <c:if test="${not empty error}">
        <div class="alert alert-danger mt-3">${error}</div>
    </c:if>
</div>
