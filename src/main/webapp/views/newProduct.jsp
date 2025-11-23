<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Product</title>
</head>
<body>
<style>
    .error {
        color: red;
    }
</style>
<h2>Create New Product</h2>
<form:form modelAttribute="productDto" action="${pageContext.request.contextPath}/productController/create"
           method="post"
           enctype="multipart/form-data">

    <form:label path="productId">Product Id</form:label>
    <form:input path="productId"/>
    <form:errors path="productId" cssClass="error"/><br>

    <form:label path="productName">Product Name</form:label>
    <form:input path="productName"/>
    <form:errors path="productName" cssClass="error"/><br>

    <form:label path="price">Price</form:label>
    <form:input path="price"/>
    <form:errors path="price" cssClass="error"/><br>

    <form:label path="title">Title</form:label>
    <form:input path="title"/>
    <form:errors path="title" cssClass="error"/><br>

    <form:label path="imageFile">Choice Image</form:label>
    <%--    Tí test thử form:input ở đây--%>
    <input type="file" id="imageFile" name="imageFile"/> <br>

    <form:label path="created">Created</form:label>
    <input type="date" id="created" name="created"/> <br>

    <label for="catalog.catalogId">Choice Catalog</label>
    <form:select path="catalog.catalogId">
        <c:forEach items="${listCategories}" var="catalog">
            <form:option value="${catalog.catalogId}">${catalog.catalogName}</form:option>
        </c:forEach>
    </form:select>

    <input type="submit" value="Create"/>

</form:form>
</body>
</html>
