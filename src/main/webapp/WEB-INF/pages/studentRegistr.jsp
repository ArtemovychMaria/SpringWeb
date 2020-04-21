<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Registration</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 600px;height: 550px; margin:auto;background-color: plum">
    <h1 style="color: blueviolet;text-align: center">Registration</h1>
<form action="/Game/students/registr" method="post">
    <img src="https://omegamma.com.au/wp-content/uploads/2017/04/default-image.jpg" id="student-photo"
         width="200px">

    <div class="form-group">
        <label for="photo-file" style="color: blueviolet">Download your photo</label>
        <input id="photo-file" type="file" />
    </div>

    <input type="hidden" value=""
           class="form-control"
           id="photo-id" name="photoId">

    <div class="form-group">
        <label for="firstName" style="color: blueviolet">Enter your Name:</label><input type="text"
                                                          class="form-control" id="firstName"
                                                          name="firstName"
                                                          value="${student.firstName}">
    </div>
    <div class="form-group">
        <label for="lastName" style="color: blueviolet">Enter your Last Name:</label><input type="text"
                                                class="form-control" id="lastName"
                                                name="lastName"
                                                value="${student.lastName}">
    </div>

    <div class="form-group">
        <label for="age" style="color: blueviolet">Enter your age:</label><input type="text"
               class="form-control" id="age"
               name="age"
               value="${student.age}">
    </div>

    <button type="submit" class="btn btn-default">Submit</button>
</form>

    <script src="${pageContext.request.contextPath}/js/studentPhoto.js"></script>

</div>
</body>
</html>