<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>No</th>
        <th>Catalog Id</th>
        <th>Catalog Name</th>
        <th>Description</th>
        <th>Status</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCategories}" varStatus="loop" var="catalog">
        <tr>
            <td>${(page - 1) * size + loop.index + 1}</td>
            <td>${catalog.catalogId}</td>
            <td>${catalog.catalogName}</td>
            <td>${catalog.description}</td>
            <td>${catalog.status ? "Hoạt động" : "Không hoạt động"}</td>
            <td></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div>
    <c:forEach var="i" begin="1" end="${totalPages}">
        <a href="${pageContext.request.contextPath}/categoriesController/findAll?page=${i}&size=${size}"
           style="${i == page ? 'font-weight:bold;color:red;' : ''}">
                ${i}
        </a>
    </c:forEach>
</div>

<br/>
<a href="${pageContext.request.contextPath}/categoriesController/initCreate">Create new catalog....</a>
</body>
</html>
