package mavs_catering.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import masv_catering.model.User;
import masv_catering.model.UserErrorMsgs;
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
		if(action.equalsIgnoreCase("BookEvent")) {
			
		}
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
			String selectedDate = request.getParameter("iddate");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date SelectedDate = null;
			try {
				SelectedDate = sdf.parse(selectedDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Calendar cal = Calendar.getInstance();
			cal.setTime(SelectedDate);

			String selectedTime = request.getParameter("idtime");

			String string1 = selectedTime+":00";
		    Date time1 = null;
			try {
				time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Calendar calendar1 = Calendar.getInstance();
		    calendar1.setTime(time1);
		    calendar1.add(Calendar.DATE, 1);

		    String weekendOpeningTime = "12:00:00";
		    Date time2 = null;
			try {
				time2 = new SimpleDateFormat("HH:mm:ss").parse(weekendOpeningTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Calendar calendar2 = Calendar.getInstance();
		    calendar2.setTime(time2);
		    calendar2.add(Calendar.DATE, 1);
		    
		    
		    
		    String weekdayOpeningTime = "07:00:00";
		    Date time3 = null;
			try {
				time3 = new SimpleDateFormat("HH:mm:ss").parse(weekdayOpeningTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Calendar calendar3 = Calendar.getInstance();
		    calendar3.setTime(time3);
		    calendar3.add(Calendar.DATE, 1);
		    
		    String weekdayClosingTime = "23:00:00";
		    Date time4 = null;
			try {
				time4 = new SimpleDateFormat("HH:mm:ss").parse(weekdayClosingTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Calendar calendar4 = Calendar.getInstance();
		    calendar4.setTime(time4);
		    calendar4.add(Calendar.DATE, 1);

		    String weekendClosingtime = "02:00:00";
		    Date time5 = null;
			try {
				time5 = new SimpleDateFormat("HH:mm:ss").parse(weekendClosingtime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    Calendar calendar5 = Calendar.getInstance();
		    calendar5.setTime(time5);
		    calendar5.add(Calendar.DATE, 1);
		
		    Date x = calendar1.getTime();

		    //Validation : if its a weekday and the time for request is less than 7am
		    if(cal.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY)
		    	{
		    	if(x.before(calendar3.getTime())
		    		|| x.after(calendar4.getTime())) {
		    		url = "/NoEvents.jsp";
		    	}
		    	else {
		    		url = "/EventBook.jsp";
		    	}
		    	
		    }
		    
		    //Validation : if its a weekend and the time of request is less than noon
			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY 
					|| cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ) {
				if(x.before(calendar2.getTime())
					|| x.after(calendar5.getTime()))
				{
					url = "/NoEvents.jsp";
				}
				else {
					url = "/NoEvents.jsp";
				}
				
			}
			getServletContext().getRequestDispatcher(url).forward(request, response);
			
			}
		}
	}

}
