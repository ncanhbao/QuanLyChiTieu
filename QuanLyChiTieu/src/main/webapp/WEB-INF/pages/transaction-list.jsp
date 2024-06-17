<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
                        <a href="/transactions-edit/${transaction.id}" class="btn btn-primary btn-sm">Sửa</a>
                        <a href="/transactions-delete/${transaction.id}" class="btn btn-danger btn-sm">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="row">
        <div class="col-md-3">
            <div class="form-group">
                <label for="pageSize">Số lượng hiển thị:</label>
                <select class="form-control" id="pageSize" name="pageSize">
                    <c:forEach items="${pageSizes}" var="size">
                        <option value="${size}" ${selectedPageSize == size ? 'selected' : ''}>${size}</option>
                    </c:forEach>
                    <option value="0" ${selectedPageSize == 0 ? 'selected' : ''}>Tất cả</option>
                </select>
            </div>
        </div>
        <div class="col-md-9">
            <div class="form-group">
                <label>Trang:</label>
                <div>
                    <c:forEach begin="1" end="${totalPages}" var="i">
                        <a href="<c:url value="/transaction-list?page=${i}&pageSize=${selectedPageSize}" />" class="btn btn-outline-primary ${currentPage == i ? 'active' : ''}">
                            ${i}
                        </a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

                    <a href="<c:url value="/transaction-add" />" class="btn btn-success" style="margin-top: 10px">Thêm giao dịch mới</a>
</div>
