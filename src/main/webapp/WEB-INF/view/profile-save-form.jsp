<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
    <h3>Update Profile:</h3>
    <form:form action="${pageContext.request.contextPath}/profile/saveUser" method="post">
        <input type="hidden" name="id" value="${user.id}">

        <div class="form-group">
            <label for="userName">Name:</label>
            <input type="text" id="userName" name="userName" value="${user.userName}" required>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${user.email}" required>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" value="${user.password}" required>
        </div>

        <div class="button-group">
            <input type="submit" value="Update" class="update-button">
        </div>
    </form:form>
</div>
</body>
</html>

