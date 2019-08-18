<%@ page isELIgnored="false"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<h2>Registration Page</h2>
  <spring:form action="${pageContext.request.contextPath}/addTask" modelAttribute="todo" method="post">
  
  <c:if test="${not empty subject}">
    <div class="form-group">
      <label for="todoId">TodoId</label>
      <spring:input type="text" class="form-control" disabled="true" readonly="true" id="todoId"  path="todoId"/>
      <spring:hidden path="todoId"/>
    </div>
  
  </c:if>
  
    <div class="form-group">
      <label for="subject">Subject</label>
      <spring:input type="text" class="form-control" id="subject" placeholder="Enter Subject" path="subject"/>
    </div>
    <div class="form-group">
      <label for="detail">Detail</label>
      <spring:textarea class="form-control" id="detail" placeholder="Enter detail" path="detail" row="3" cols="20"/>
    </div>
    
     <div class="form-group">
      <label for="assignmentDate">Date of Assignment</label>
      <spring:input type="date" class="form-control" id="assignmentDate" placeholder="Enter Date of Assignment" path="assignmentDate"/>
    </div>
    
     <div class="form-group">
      <label for="targetDate">Target Date</label>
      <spring:input type="date" class="form-control" id="targetDate" placeholder="Target Date" path="targetDate"/>
    </div>
    
     <div class="form-group">
      <label for="targetTime">Target Date</label>
      <spring:input type="time" class="form-control" id="targetTime" placeholder="Target time" path="targetTime"/>
    </div>
    
    <c:if test="${empty subject}">
    <button type="submit" class="btn btn-primary">Add</button>
    </c:if>
    <c:if test="${not empty subject}">
    <button type="submit" class="btn btn-primary">Update</button>
    </c:if>
  </spring:form>


<div class="container">
  <h2>UserList</h2>
            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>TodoId</th>
        <th>subject</th>
        <th>Detail</th>
        <th>Date of Assignment</th>
        <th>Target Date</th>
        <th>Target Time</th>
        <th>Status</th>
        <th>Delete</th>
        <th>Update</th>
        
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${taskList}" var="task">
      <tr>
        <td>${task.todoId}</td>
        <td>${task.subject}</td>
        <td>${task.detail}</td>
        <td>${task.assignmentDate}</td>
        <td>${task.targetDate}</td>
        <td>${task.targetTime}</td>
        <td>${task.status}</td>
        <td><a href="deleteTask/${todoId}">Delete</a></td>
        <td><a href="updateTask/${todoId}">update</a></td>
      </tr>
      </c:forEach>
      
      <spring:form action="status" modelAttribute="todo">
      <B>Filter:</B>
       <spring:select path="status">
        <fm:option value="Active">Active</fm:option>
        <fm:option value="InActive">InActive</fm:option>
      </spring:select>

 <button type="submit" class="btn btn-primary">Filter</button>
</spring:form>
<c:if test="${not empty statusList}">
 <table class="table table-hover">
    <thead>
      <tr>
        <th>TodoId</th>
        <th>subject</th>
        <th>Detail</th>
        <th>Date of Assignment</th>
        <th>Target Date</th>
        <th>Target Time</th>
 </tr>
  <c:forEach items="${statusList}" var="task">
      <tr>
      <tr>
        <td>${task.todoId}</td>
        <td>${task.subject}</td>
        <td>${task.detail}</td>
        <td>${task.assignmentDate}</td>
        <td>${task.targetDate}</td>
        <td>${task.targetTime}</td>
      </tr>   
       </c:forEach>
</c:if>







</body>
</html>
