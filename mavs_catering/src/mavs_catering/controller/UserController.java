package mavs_catering.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import masv_catering.model.Event;
import masv_catering.model.EventErrorMsgs;
import masv_catering.model.User;
import masv_catering.model.UserErrorMsgs;
import mavs_catering.data.EventDAO;
import mavs_catering.data.UserDAO;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		String action = request.getParameter("action");
		String url = "/Login.jsp";
		if(action.equalsIgnoreCase("EventRequest")) {
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");  
			  LocalDateTime now = LocalDateTime.now();  
			   
			session.setAttribute("CurrentTime", dtf.format(now));
			session.setAttribute("CurrentDate", java.time.LocalDate.now());
			//2020-02-12
			url = "/EventRequest.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();	
		String action = request.getParameter("action");
	
		String url = "/Login.jsp";
		
		if (action.equalsIgnoreCase("BookEvent") ) {
		if (request.getParameter("NextBtn")!=null) 
		{
			Event event = new Event();
			String selectedDate = request.getParameter("iddate");
			String selectedTime = request.getParameter("idtime");
			EventErrorMsgs EerrorMsgs = new EventErrorMsgs();
			event.validateSelectedDateTime(selectedDate, selectedTime, EerrorMsgs);
			try {
				event.validateselectedDate(selectedDate, EerrorMsgs);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			session.setAttribute("TIMEERROR", EerrorMsgs);
			if (EerrorMsgs.getErrorMsg().equals("")) {
				session.removeAttribute("errorMsgs");
				String firstname = EventDAO.getfirstname(session.getAttribute("userid").toString());
				String lastname = EventDAO.getlastname(session.getAttribute("userid").toString());
				session.setAttribute("fname", firstname);
				session.setAttribute("lname", lastname);
				session.setAttribute("date", selectedDate);
				session.setAttribute("time", selectedTime);
				url = "/EventBook.jsp";
			}
			else {
				url = "/EventRequest.jsp";
			}

			getServletContext().getRequestDispatcher(url).forward(request, response);
			
			}
		}
	}

}
