<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Thêm Mặt Bằng</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        form {
            width: 300px;
            margin: 50px auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"], input[type="number"], input[type="date"], select, textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            border: none;
            border-radius: 4px;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        button {
            width: 48%;
            background-color: #f44336;
        }

        button:hover {
            background-color: #e53935;
        }
    </style>
</head>
<body>
<h2>Thêm Mặt Bằng</h2>
<c:if test="${message != null}">
    <div class="alert alert-success" role="alert">
        Thêm mặt bằng thành công!
    </div>
</c:if>
<c:if test="${errorMessage1 != null}">
    <div class="alert alert-danger" role="alert">
        Thêm mặt bằng thất bại! Ngày bắt đầu phải nhỏ hơn ngày kết thúc ít nhất 6 tháng
    </div>
</c:if>
<c:if test="${errorMessage2 != null}">
    <div class="alert alert-danger" role="alert">
        Thêm mặt bằng thất bại! Mặt bằng đã tồn tại
    </div>
</c:if>
<form action="/matbang/them" method="post">
    <label for="maMatBang">Mã mặt bằng (*):</label>
    <input type="text" id="maMatBang" name="maMatBang" required pattern="[\dA-Z]{3}-[\dA-Z]{2}-[\dA-Z]{2}">

    <label for="dienTich">Diện tích (*):</label>
    <input type="number" id="dienTich" name="dienTich" required min="20">

    <label for="trangThai">Trạng thái (*):</label>
    <select id="trangThai" name="trangThai" required>
        <option value="Trống">Trống</option>
        <option value="Hạ tầng">Hạ tầng</option>
        <option value="Đầy đủ">Đầy đủ</option>
    </select>

    <label for="tang">Tầng (*):</label>
    <select id="tang" name="tang" required>
        <% for (int i = 1; i <= 15; i++) { %>
        <option value="<%= i %>"><%= i %>
        </option>
        <% } %>
    </select>

    <label for="loaiMatBang">Loại mặt bằng (*):</label>
    <select id="loaiMatBang" name="loaiMatBang" required>
        <option value="văn phòng chia sẻ">Văn phòng chia sẻ</option>
        <option value="Văn phòng trọn gói">Văn phòng trọn gói</option>
    </select>

    <label for="moTaChiTiet">Mô tả chi tiết:</label>
    <textarea id="moTaChiTiet" name="moTaChiTiet" rows="4"></textarea>

    <label for="giaTien">Giá cho thuê (*):</label>
    <input type="number" id="giaTien" name="giaTien" required min="1000000">

    <label for="ngayBatDau">Ngày bắt đầu (*):</label>
    <input type="text" id="ngayBatDau" name="ngayBatDau" placeholder="dd/MM/yyyy" required>

    <label for="ngayKetThuc">Ngày kết thúc (*):</label>
    <input type="text" id="ngayKetThuc" name="ngayKetThuc" placeholder="dd/MM/yyyy" required>

    <input type="submit" value="Lưu">
    <button type="reset">Hủy</button>
</form>
</body>
</html>