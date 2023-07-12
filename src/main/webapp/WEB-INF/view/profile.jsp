<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div class="container">
    <h1>Welcome, ${user.userName}!</h1>

    <h3>Profile Information:</h3>
    <p>Email: ${user.email}</p>

    <h3>Update Profile:</h3>
    <a href="${pageContext.request.contextPath}/profile/update?userId=${user.id}" class="edit-profile-button">Edit Profile</a>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <button type="submit" class="logout-button">Logout</button>
    </form:form>
</div>
</body>
</html>
