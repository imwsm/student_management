<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  	
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">       		
	<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourcesFolder/css/add-student.css">
	<link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourcesFolder/css/mystylesheet.css" >
        
	

</head>
<body>

	<div align="center" class="myFonts">
	<h1>Add A New Student Details</h1 >
	
	<!-- createing spring form for adding new student -->
		
		<form:form action="save-student" modelAttribute="student" method="POST">
		
		
		<form:hidden path="id" />
		</br>
		</br>
		<label> Name : </label>
		<form:input path="name" />
		</br>
		</br>
		<label> Mobile : </label>
		<form:input path="mobile" />	
		</br>
		</br>
		<label> Country : </label>
		<form:input path="country" />
		</br>
		</br>
		<input type="submit" value="submit" class="myButton">
		<h2>
		</form:form>
		
	</div>
</body>
</html>