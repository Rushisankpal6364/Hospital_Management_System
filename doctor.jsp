<%@page import="beans.DocDao"%>
<%@page import="beans.Doctor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<%
String specialization = request.getParameter("specialization");
List<Doctor>list = DocDao.getSpecialization(specialization);
%>

<table class="table">
	<tr>
	    <th>id</th>
	    <th>deptno</th>
		<th>name</th>
		<th>lastname</th>
		<th>age</th>
		<th>specialization</th>
		<th>department</th>
	</tr>
	
<%for(Doctor doc:list){ %>
		<tr>
			<td><%=doc.getId() %></td>
		    <td><%=doc.getDeptno() %></td>
			<td><%=doc.getName() %></td>
			<td><%=doc.getLastname() %></td>
			<td><%=doc.getAge() %></td>
			<td><%=doc.getSpecialization() %></td>
			<td><%=doc.getDepartment() %></td>
		</tr>
	<%} %>
	
	<tr>
            <td>
                <button type="submit" name="btn" value="back"><a href="display.jsp" >Back</a></button>
            </td>
        </tr>
   
</body>
</html>