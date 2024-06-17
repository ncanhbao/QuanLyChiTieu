<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container">
    <h1 class="text-center text-primary mt-5">Thêm giao dịch mới</h1>
    <c:url value="/transaction-add" var="action" />
    <form:form method="post" action="${action}" modelAttribute="transaction" class="form-group mt-3">
        <div class="mb-3">
            <label for="date" class="form-label">Ngày giao dịch</label>
            <form:input path="date" type="date" class="form-control" id="date" />
        </div>
        <div class="mb-3">
            <label for="amount" class="form-label">Số tiền</label>
            <form:input path="amount" class="form-control" id="amount" />
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Mô tả</label>
            <form:textarea path="description" class="form-control" id="description" rows="3"></form:textarea>
        </div>
        <div class="mb-3">
            <label for="category" class="form-label">Nhóm chi tiêu</label>
            <form:select path="categoryId.id" class="form-control" id="category">
                <form:option value="">Chọn nhóm chi tiêu</form:option>
                <c:forEach items="${categories}" var="category">
                    <form:option value="${category.id}">${category.name}</form:option>
                </c:forEach>
            </form:select>
        </div>
        <button type="submit" class="btn btn-primary">Lưu giao dịch</button>
    </form:form>

    <c:if test="${not empty error}">
        <div class="alert alert-danger mt-3">${error}</div>
    </c:if>
</div>
