package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.RegisterService;

/*
 * This servlet reads the input parameters to
 */
public class RegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 
	 String userId = request.getParameter("userId");
	 String email = request.getParameter("email");
	 String password = request.getParameter("password");
	 String firstName = request.getParameter("firstName");
	 String lastName = request.getParameter("lastName");
	 String address = request.getParameter("address");
	 String phone = request.getParameter("phone");
	 boolean isAdmin = request.getParameter("isAdmin")!= null; //true if checked, and false if not checked
	 
	 
	
	 User user = new User(userId, email, password, firstName, lastName, address, phone);
			
	 try {	
		 RegisterService registerService = new RegisterService();
		 boolean result = registerService.register(user);		
		 out.println("<html>");
		 out.println("<head>");		
		 out.println("<title>Registration Successful</title>");		
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<center>");
		 if(result){
			 out.println("<h1>Thanks for Registering with us :</h1>");
			 out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
		 }else{
			 out.println("<h1>Registration Failed</h1>");
			 out.println("To try again<a href=register.jsp>Click here</a>");
		 }
		 out.println("</center>");
		 out.println("</body>");
		 out.println("</html>");
	 } finally {		
		 out.close();
	 }
}

}