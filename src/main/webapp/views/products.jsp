<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Products</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Product ID</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Avatar</th>
        <th>Created</th>
        <th>Catalog Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="product" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td><img src="${product.avatar}" alt="${product.productName}" height="50px" width="50px"></td>
            <td>${product.created}</td>
            <td>${product.catalog.catalogName}</td>
            <td><a href="<%=request.getContextPath()%>/productController/initUpdate?productId=${product.productId}">Update</a>
                <a href="<%=request.getContextPath()%>/productController/delete?productId=${product.productId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="<%=request.getContextPath()%>/productController/initCreate">Create new Product</a>
</body>
</html>
