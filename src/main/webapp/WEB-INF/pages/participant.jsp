<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.example.SpringWeb.MVC.LEVELS"%>
<html lang="en">
<head>
    <title>Lesson-18</title>
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

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <ul class="nav navbar-nav">
            <li class="active"><a href="/Game/participants/">All participants</a></li>
            <li><a href="/Game/participants/new">new Participants</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <c:choose>
        <c:when test="${mode== 'PARTICIPANT_VIEW'}">
        <table class="table table-stripped">
            <thead>
            <tr>
                <th>Id</th>
                <th>Participant Name</th>
                <th>Participant Email</th>
                <th>Level</th>
                <th>Primary Skill</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="participant" items="${participants}">
                <tr>
                    <td>${participant.id}</td>
                    <td>${participant.name}</td>
                    <td>${participant.email}</td>
                    <td>${participant.level}</td>
                    <td>${participant.primarySkill}</td>
                    <td><a href="/Game/participants/update?id=${participant.id}">edit</a> </td>
                    <td><a href="/Game/participants/delete?id=${participant.id}">delete</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:when>

        <c:when test="${mode== 'PARTICIPANT_EDIT' || mode== 'PARTICIPANT_CREATE'}">
            <form action="${mode == 'PARTICIPANT_EDIT' ? "/Game/participants/save": "/Game/participants/create"}" method="post">
                <c:choose>
                        <c:when test="${mode == 'PARTICIPANT_EDIT'}">
                    <input type="hidden" value="${participant.id}" class="form-control" id="id" name="id">
                        </c:when>
                    </c:choose>
                <div class="form-group">
                    <label for="name">Participant Name:</label><input type="text"
                                                                      class="form-control" id="name"
                                                                      name="name"
                                                                      value="${participant.name}">
                </div>
                <div class="form-group">
                    <label for="email">Email:</label><input type="text"
                                                            class="form-control" id="email"
                                                            name="email"
                                                            value="${participant.email}">
                </div>

                <div class="form-group">
                    <label for="level">Enter your level:</label>
                    <ul>
                        <c:forEach var="enumValue" items="<%=LEVELS.values()%>">
                        <li>${enumValue}</li>
                        </c:forEach>
                    </ul>
                    <input type="text"
                           class="form-control" id="level"
                           name="level"
                           value="${participant.level}">
                </div>
                <div class="form-group">
                    <label for="skill">Primary Skill:</label><input type="text"
                                                            class="form-control" id="skill"
                                                            name="primarySkill"
                                                            value="${participant.primarySkill}">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
        </c:when>
    </c:choose>
</div>

</body>
</html>