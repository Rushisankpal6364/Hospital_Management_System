package beans;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	int id = Integer.parseInt(request.getParameter("id"));
	int status = DocDao.DeleteData(id);
	
	
	if(status == 1) {
		response.sendRedirect("display.jsp");
	}else {
		System.out.println("<<-----Unable to Delete Data-------->>");
	}
	
}

}
