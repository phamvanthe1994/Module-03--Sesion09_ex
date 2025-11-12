<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Catalog</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/categoriesController/create" method="post">
    <label for="catalogName">Catalog Name</label>
    <input type="text" name="catalogName" id="catalogName"/><br>

    <label for="description">Description</label>
    <input type="text" id="description" name="description"/><br>

    <input type="submit" value="Create"/>
</form>
</body>
</html>
