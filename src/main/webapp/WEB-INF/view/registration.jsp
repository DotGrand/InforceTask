<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
    <form:form action="${pageContext.request.contextPath}/processRegistrationForm" method="post">
        <h1>Registration</h1>
        <c:if test="${registrationError != null}">

            <div class="error-message">
                    ${registrationError}
            </div>

        </c:if>

        <div class="form-group">
            <label for="userName">UserName:</label>
            <input type="text" id="userName" name="userName"/>
            <c:if test="${not empty errors.userName}">
                <div class="error-message">${errors.userName}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email"/>
            <c:if test="${not empty errors.email}">
                <div class="error-message">${errors.email}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"/>
            <c:if test="${not empty errors.password}">
                <div class="error-message">${errors.password}</div>
            </c:if>
        </div>

        <div class="button-group">
            <input type="submit" value="Register" class="register-button">
        </div>
    </form:form>
</div>
</body>
</html>
