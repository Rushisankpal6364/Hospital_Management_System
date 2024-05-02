package beans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		int age = Integer.parseInt(request.getParameter("age"));
		String specialization = request.getParameter("specialization");
		String department = request.getParameter("department");
		
		
		int status = DocDao.UpdateDoctor(deptno, name, lastname, age, specialization, department, id);
		
		if(status == 1) {
			response.sendRedirect("display.jsp");
		}else {
			response.sendRedirect("index.html");
		}
	}

}
