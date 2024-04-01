<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 01/04/2024
  Time: 9:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Create New Student</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <h1>Create New Student</h1>
  <form action="/add-student" method="POST">
    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" class="form-control" id="name" name="name" required>
    </div>
    <div class="form-group">
      <label for="email">Email</label>
      <input type="email" class="form-control" id="email" name="email" required>
    </div>
    <div class="form-group">
      <label for="dob">Date of Birth</label>
      <input type="date" class="form-control" id="dob" name="dob" required>
    </div>
    <div class="form-group">
      <label for="address">Address</label>
      <input type="text" class="form-control" id="address" name="address" required>
    </div>
    <div class="form-group">
      <label for="phoneNumber">Phone Number</label>
      <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required>
    </div>
    <div class="form-group">
      <label for="classroomId">Classroom</label>
      <select class="form-control" id="classroomId" name="classroomId" required>
        <option value="">Select Classroom</option>
        <%-- Loop through classrooms and populate dropdown options --%>
        <c:forEach var="classroom" items="${classrooms}">
          <option value="${classroom.id}">${classroom.name}</option>
        </c:forEach>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Create</button>
  </form>
</div>
</body>
</html>

