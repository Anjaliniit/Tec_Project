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
    <div class="form-group">
      <label for="subject">Subject</label>
      <spring:input type="text" class="form-control" id="subject" placeholder="Enter Subject" path="subject"/>
    </div>
    <div class="form-group">
      <label for="detail">Detail</label>
      <spring:input type="text" class="form-control" id="detail" placeholder="Enter detail" path="detail"/>
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
    
    
    <button type="submit" class="btn btn-primary">Submit</button>
  </spring:form>





</body>
</html>
