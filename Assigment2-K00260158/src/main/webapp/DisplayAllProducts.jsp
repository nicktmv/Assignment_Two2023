<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/WEB-INF/includes/header.jsp"/>
<!DOCTYPE html>
<html>
<head>
    <title>Zelora</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/jquery.dataTables.css" />
    <script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.js"></script>

</head>
<body>
<div class="container">
    <h2>All Products</h2>
    <table id="prodTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
            <th>Image</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Size</th>
            <th>Color</th>
            <th>Sustainability Rating</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td><a href="GetProductByID?id=${products.productID}"><img src="assets/images/thumbs/${product.product_image}" alt="${product.product_name}" width="100" height="100"></a></td>
                <td>${product.product_name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>${product.size}</td>
                <td>${product.color}</td>
                <td>${product.sustainability_rating}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>