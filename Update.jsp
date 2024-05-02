<%@page import="beans.Doctor"%>
<%@page import="beans.DocDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
     int id = Integer.parseInt(request.getParameter("id"));
     Doctor doc = DocDao.getDoctor(id);
%>
<form action="Update" method="POST">
<h1>Welcome to Update page</h1>
        <table>
        <tr>
            <td><label>Deptno :</label> </td>
            <td><input type="text" name="deptno" value="<%=doc.getDeptno()%>"></td>
        </tr>
        <tr>
            <td>Name :</td>
            <td><input type="text" name="name" value="<%=doc.getName()%>"></td>   
        </tr>
        <tr>
            <td>LastName :</td>
            <td><input type="text" name="lastname" value="<%=doc.getLastname()%>"></td>   
        </tr>
        <tr>
            <td>Age :</td>
            <td><input type="text" name="age" value="<%=doc.getAge()%>"></td>   
        </tr>
        <tr>
            <td>Specialization :</td>
            <td><input type="text" name="specialization" value="<%=doc.getSpecialization()%>"></td>   
        </tr>
        <tr>
            <td>Department :</td>
            <td><input type="text" name="department" value="<%=doc.getDepartment()%>"></td>   
        </tr>
        
        <tr>
            <td><input type="hidden" name="id" value="<%=doc.getId()%>"></td>   
        </tr>
        <tr>
            <td>
                <button type="submit" name="btn" value="insert">Update</button>
            </td>
        </tr>
        
    </table>
    </form>
</body>
</html>