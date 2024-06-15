<%-- 
    Document   : transaction-add
    Created on : May 31, 2024, 2:34:59 PM
    Author     : ncanh
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <h1 class="text-center text-primary mt-5">Thêm giao dịch mới</h1>
    <form:form method="post" action="/transactions-add" modelAttribute="transaction" class="form-group mt-3">
        <div class="mb-3">
            <label for="type" class="form-label">Loại giao dịch</label>
            <form:input path="type" class="form-control" id="type" placeholder="Loại giao dịch" />
        </div>
        <div class="mb-3">
            <label for="amount" class="form-label">Số tiền</label>
            <form:input path="amount" class="form-control" id="amount" placeholder="Số tiền" />
        </div>
        <div class="mb-3">
            <label for="date" class="form-label">Ngày giao dịch</label>
            <form:input path="date" class="form-control" id="date" placeholder="Ngày giao dịch" />
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô tả</label>
            <form:textarea path="description" class="form-control" id="description" placeholder="Mô tả" />
        </div>
        <div class="mb-3">
            <label for="categoryId" class="form-label">Nhóm chi tiêu</label>
            <form:select path="categoryId" class="form-control" id="categoryId">
                <form:option value="" label="Chọn nhóm chi tiêu" />
                <form:options items="${categories}" itemValue="id" itemLabel="name" />
            </form:select>
        </div>
        <div class="mb-3">
            <label for="groupId" class="form-label">Nhóm</label>
            <form:select path="groupId" class="form-control" id="groupId">
                <form:option value="" label="Chọn nhóm" />
                <form:options items="${groups}" itemValue="id" itemLabel="name" />
            </form:select>
        </div>
        <button type="submit" class="btn btn-primary">Thêm giao dịch</button>
    </form:form>

    <c:if test="${not empty error}">
        <div class="alert alert-danger mt-3">${error}</div>
    </c:if>
</div>
