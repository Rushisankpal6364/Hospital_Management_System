<%@page import="beans.Doctor"%>
<%@page import="beans.DocDao"%>
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

<body >

<%
List<Doctor>list = DocDao.getAllDoctor();
%>

 <tr>
   <td><label>Specialization : </label></td>
       <td>
       <form action='doctor.jsp' method='get'>
       
       <select id="specialization" name="specialization">
       <option value="test">----select option----</option>                  
       <option value="Cardiologist">Cardiologist</option>
       <option value="Audiologist">Audiologist</option>
       <option value="Dentist">Dentist</option>
       <option value="ENTspecialist">ENT specialist</option>
       <option value="Gynecologist">Gynecologist</option>
       <option value="Orthopedicsurgeon">Orthopedicsurgeon</option>
       <option value="Peditricians">Peditricians</option>
       <option value="Psychiatrists">Psychiatrists</option>
       <option value="Neurologist">Neurologist</option>
       <option value="Cardiacsurgeon">Cardiac surgeon</option>
       </select>
       <input type='submit' />
       </form>
       </td>    
   </tr>
   
   
<table class="table">
	<tr>
	    <th>id</th>
	    <th>deptno</th>
		<th>name</th>
		<th>lastname</th>
		<th>age</th>
		<th>specialization</th>
		<th>department</th>
		<th>Delete Option</th>
		<th>Update Option</th>
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
			<td><a href='Delete?id=<%=doc.getId()%>'>Delete</a></td>
		    <td><a href='Update.jsp?id=<%=doc.getId()%>'>Update</a></td>
		   
		</tr>
	<%} %>
	</table>
</body>
</html>