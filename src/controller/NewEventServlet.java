package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Event;
import service.NewEventService;

/**
 * This servlet is used to get parameters form add-new event form and call the
 * new event service to add it to the database
 */
@WebServlet("/NewEventServlet")
public class NewEventServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public NewEventServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	// We use doPost method to read the parameters and call add-new event
	// service

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("eventID"));
		String name = request.getParameter("eventName");
		String type = request.getParameter("eventType");
		String desc = request.getParameter("eventDesc");
		String startSt = request.getParameter("eventName");
		String endSt = request.getParameter("eventName");

		Event event = new Event(001, "Graduate", "Graduate", "highschool graduation", new Date(), new Date());
		try {
			NewEventService newEventService = new NewEventService();
			boolean result = newEventService.addNewEvent(event);
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Event Created Successful</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<center>");
			if (result) {
				out.println("To login with new UserId and Password<a href=login.jsp>Click here</a>");
			} else {
				out.println("<h1> Cannot add new event! </h1>");
				out.println("To try again<a href=newEvent.jsp>Click here</a>");
			}
			out.println("</center>");
			out.println("</body>");
			out.println("</html>");
		} finally {
			out.close();
		}
	}

}
