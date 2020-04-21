<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Cabinet</title>
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
    <h1 style="color: darkcyan">Welcome to your personal cabinet ${student.firstName}</h1>
    <div style="width:550px;display: flex; justify-content:space-around">
    <div>  <img src="/Game/student-photo-files/download/${student.photoId}" width="300px"></div>
    <div style="width: 200px">
        <table>
        <tr>
            <td><h3 style="color: darkcyan">Name:</h3></td>
            <td><h3 style="color: darkcyan">${student.firstName}</h3></td>
        </tr>
        <tr>
            <td><h3 style="color: darkcyan">Surname:</h3></td>
            <td><h3 style="color: darkcyan">${student.lastName}</h3></td>
        </tr>
            <tr>
                <td><h3 style="color: darkcyan">Age:</h3></td>
                <td><h3 style="color: darkcyan">${student.age}</h3></td>
            </tr>
    </table>
    </div>
</div>
</body>
</html>