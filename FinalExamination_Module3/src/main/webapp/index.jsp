<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Management</title>
  <!-- Bootstrap CSS -->
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
  <h1>Student Management</h1>
  <!-- Table to display students -->
  <table class="table">
    <thead>
    <tr>
      <th>Name</th>
      <th>Email</th>
      <th>Date of Birth</th>
      <th>Address</th>
      <th>Phone Number</th>
      <th>Classroom</th>
      <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}">
      <tr>
        <td>${student.name}</td>
        <td>${student.email}</td>
        <td>${student.dob}</td>
        <td>${student.address}</td>
        <td>${student.phoneNumber}</td>
        <td>${student.classroom.name}</td>
        <td>
          <a href="/update-student?id=${student.id}" class="btn btn-primary">Edit</a>
          <a href="/delete-student?id=${student.id}" class="btn btn-danger">Delete</a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <!-- Button to add new student -->
  <a href="${pageContext.request.contextPath}/add-student" class="btn btn-success">Add New Student</a>
  <!-- Search form -->
  <form action="search.jsp" method="GET">
    <div class="form-group">
      <input type="text" class="form-control" name="name" placeholder="Search by Name">
    </div>
    <button type="submit" class="btn btn-primary">Search</button>
  </form>
</div>
</body>
</html>


