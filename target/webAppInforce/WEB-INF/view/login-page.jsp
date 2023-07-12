<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
    <form:form action="${pageContext.request.contextPath}/authenticate" method="POST">
        <h1>Login</h1>
        <c:if test="${param.error != null}">
            <div class="error-message">
                <b>Wrong email or password!</b>
            </div>
        </c:if>
        <div class="form-group">
            <label for="username">Email</label>
            <input type="text" id="username" placeholder="Email" name="username"/>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" placeholder="Password" name="password"/>
        </div>

        <div class="button-group">
            <button class="login-button" type="submit">Login</button>
        </div>
    </form:form>

    <div class="link-group">
        <p>Don't have an account? <a href="${pageContext.request.contextPath}/registration">Register</a></p>
    </div>
</div>
</body>
</html>
