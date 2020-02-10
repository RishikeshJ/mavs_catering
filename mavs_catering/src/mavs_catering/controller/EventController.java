package mavs_catering.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import masv_catering.model.Event;
import masv_catering.model.User;
import masv_catering.model.UserErrorMsgs;
import mavs_catering.data.EventDAO;
import mavs_catering.data.UserDAO;

/**
 * Servlet implementation class EventController
 */
@WebServlet("/EventController")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String action = request.getParameter("action"), url ="";
        String EventID = request.getParameter("eventID");
		if(action.equalsIgnoreCase("viewSepcificEvent"))
        {
        	System.out.println(EventID);
        	Event event = new Event();
        	event = EventDAO.getSpecificEvent(EventID);
            session.setAttribute("REGISTEREVENT", event);
            url  ="/PayDeposit.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        	
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String action = request.getParameter("action");
		HttpSession session = request.getSession();	
		String url = "/EventBook.jsp";
		
		if (action.equalsIgnoreCase("BookEvent") ) {  
			Event event = new Event();
			event.setEvent(request.getParameter("lastName"), request.getParameter("firstName"),
					request.getParameter("iddate"),  request.getParameter("idtime"),
					request.getParameter("duration"),request.getParameter("hallName"), 
					request.getParameter("estAttendees"),request.getParameter("eventName"),
					request.getParameter("foodType"),request.getParameter("meal"),
					request.getParameter("mealFormality"),request.getParameter("drinkType"),
					request.getParameter("entertainmentItems"),"Pending","","N/A","N/A","N/A");
			UserErrorMsgs UerrorMsgs = new UserErrorMsgs();
			//user.validateUser(user, UerrorMsgs);
			session.setAttribute("EVENT",event);
			session.setAttribute("errorMsgs",UerrorMsgs);
			if (UerrorMsgs.getErrorMsg().equals("")) {
				EventDAO.registerEvent(event);
				ArrayList<Event> PendingEvents = new ArrayList<Event>();
				PendingEvents = EventDAO.listEvents();
				session.setAttribute("PendingEvents", PendingEvents);
				session.removeAttribute("errorMsgs");
				//session.removeAttribute("EVENT");
				url = "/PayDeposit.jsp";
			}
		}
		else if(action.equalsIgnoreCase("PayFinalDeposit")) {
			//Event event = new Event();
			System.out.println(session.getAttribute("Event.lastName"));
			//event.setEvent(session.getAttribute("Event.lastName"), session.getAttribute(""))
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
