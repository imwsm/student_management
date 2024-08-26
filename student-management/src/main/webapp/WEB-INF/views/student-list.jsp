<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Student Management App</title>
    
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="/student-management/URLToReachResourcesFolder/css/mystylesheet.css">
    </head>
    <body class="myFonts">
    
    <div class="container" >
    
    <h1  align="center">Student Management App</h1>
    
   	

    
        
        
        <form action="showAddStudent" class="text-center">
        <input type="submit" value="ADD NEW"  class="btn btn-outline-success">
        </form>
        <br/>
        
        <table class="table table-hover text-center">
            <thead>
                <tr>
                    <td>id</td>
                    <td>name</td>
                    <td>mobile</td>
                    <td>country</td>
                    <td>Update</td>
                    <td>Delete</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.mobile}</td>
                        <td>${student.country}</td>
                        <td><a href="/student-management/updateStudent?userId=${student.id}" class="btn btn-primary">Update</a></td>
                        <td>
                            <a href="/student-management/deleteStudent?userId=${student.id}" 
                               onclick="return confirm('Are you sure? The record will no longer be available.');"
                               class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    </body>
</html>
