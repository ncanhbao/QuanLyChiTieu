<%-- 
    Document   : transaction-list
    Created on : May 30, 2024, 3:45:30 PM
    Author     : ncanh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách giao dịch</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h1>Danh sách giao dịch</h1>

        <table class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Ngày</th>
                    <th>Loại giao dịch</th>
                    <th>Số tiền</th>
                    <th>Nhóm chi tiêu</th>
                    <th>Mô tả</th>
                    <th>Hành động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${transactions}" var="transaction">
                    <tr>
                        <td><fmt:formatDate value="${transaction.date}" pattern="dd/MM/yyyy" /></td>
                        <td>${transaction.type}</td>
                        <td><fmt:formatNumber value="${transaction.amount}" pattern="#,###.##" /></td>
                        <td>${transaction.category.name}</td>
                        <td>${transaction.description}</td>
                        <td>
                            <a href="/transactions/edit/${transaction.id}" class="btn btn-primary btn-sm">Sửa</a>
                            <a href="/transactions/delete/${transaction.id}" class="btn btn-danger btn-sm">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="/transactions/add" class="btn btn-success">Thêm giao dịch mới</a>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>