package controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StdDAO;
import dto.StdDTO;


@WebServlet("*.std")
public class Std_servlet extends HttpServlet {
	
       
    
    public Std_servlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		StdDAO dao = new StdDAO();
		try {
		if(uri.equals("/insert.std")) {
			String name = request.getParameter("name");
			int kor = Integer.parseInt(request.getParameter("kor"));
			int eng = Integer.parseInt(request.getParameter("eng"));
			int math = Integer.parseInt(request.getParameter("math"));
			
			int result = dao.insert(new StdDTO(0,0,name,kor,eng,math,null));
			response.sendRedirect("/index.jsp");
			
		}else if(uri.equals("/delete.std")) {
			
			int sid = Integer.parseInt(request.getParameter("sid"));
			
			
			int result = dao.delete(sid);
			response.sendRedirect("/index.jsp");
		}else if(uri.equals("/search.std")) {
			
			int name = Integer.parseInt(request.getParameter("name"));
			
			
			int result = dao.search(name);
			response.sendRedirect("/search.jsp");
		}
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
