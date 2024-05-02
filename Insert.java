package beans;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		String specialization = request.getParameter("specialization");
		String department = request.getParameter("department");
		
		boolean flag = DocDao.getDeptno(deptno);
		if(flag == true) {
			out.print("Department Number Already Exists Please Enter Another DepartmentNumber");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}else {
		
		Doctor doc = new Doctor();
		
		doc.setDeptno(deptno);
		doc.setName(name);
		doc.setLastname(lastname);
		doc.setAge(age);
		doc.setSpecialization(specialization);
		doc.setDepartment(department);
		
		int status = DocDao.insertDoctor(doc);
		
		if(status == 1) {
			System.out.println("<<------Data Inserted--------->>");
			out.print("<script>alert('data inserted...');window.location='index.html' </script>");
			
		}else {
			System.out.println("<<------Unable to Insert Data--------->>");
		}
	}
	}

}
