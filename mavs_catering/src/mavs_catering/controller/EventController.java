package mavs_catering.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
		String action = request.getParameter("action");
		String currentTime = new SimpleDateFormat("YYYY-MM-DD").format(Calendar.getInstance().getTime());
		HttpSession session = request.getSession();	
		Event event = new Event();

		String url = "/EventBook.jsp";
		if (action.equalsIgnoreCase("BookEvent") ) {  
			
			
			//UserErrorMsgs UerrorMsgs = new UserErrorMsgs();
			EventErrorMsgs EerrorMsgs = new EventErrorMsgs();
			
			String HallName = request.getParameter("hallName");
			String FoodType = request.getParameter("foodType");
			String MealFormality = request.getParameter("mealFormality");
			String DrinkType = request.getParameter("drinkType");
			String EntertainmentItems = request.getParameter("entertainmentItems");
			String Meal = request.getParameter("meal");
			double FoodMealCost = 0;
			double MealFormalityCost = 0 ;
			double DrinkCost = 0;
			double EntertainmentCost = 0;
			double FinalDepositCost = 0;
			String estAttendees = request.getParameter("estAttendees");
			
			
			/*Food meal type: breakfast, lunch, supper. Meal cost: breakfast $8/person attending, 
			lunch $12/person attending, and supper $18/person attending.*/
			if(Meal.equals("Breakfast")) {	
				FoodMealCost = Integer.parseInt(estAttendees)* 8;
			}else if(Meal.equals("Lunch")) {
				FoodMealCost = Integer.parseInt(estAttendees)* 12;
			}
			else if(Meal.equals("Supper")) {
				FoodMealCost = Integer.parseInt(estAttendees)* 18;
			}
			
			//Formal is 1.5 times the cost of the meal 
			if(MealFormality.equals("Formal")) {
				FoodMealCost = 1.5 * FoodMealCost;
			}
			//Alcohol is $15/person attending.
			if(DrinkType.equals("Alcohol")) {
				DrinkCost = Integer.parseInt(estAttendees)* 15;
			}
			
			if(EntertainmentItems.equals("Music")) {
				FinalDepositCost = FoodMealCost + MealFormalityCost + DrinkCost + 50;
			}
			else {
				FinalDepositCost = FoodMealCost + MealFormalityCost + DrinkCost;
			}
			
			session.setAttribute("DepositValue", FinalDepositCost);
			
			event.setEvent(session.getAttribute("fname").toString(),session.getAttribute("lname").toString()
					,session.getAttribute("date").toString(),session.getAttribute("time").toString(),
					request.getParameter("duration"),request.getParameter("hallName"), 
					request.getParameter("estAttendees"),request.getParameter("eventName"),
					request.getParameter("foodType"),request.getParameter("meal"),
					request.getParameter("mealFormality"),request.getParameter("drinkType"),
					request.getParameter("entertainmentItems"),"Pending","","N/A","N/A","N/A",session.getAttribute("userid").toString(),
					String.valueOf(FinalDepositCost));
				event.validateEvent(event, EerrorMsgs);
				event.validateduration(session.getAttribute("date").toString(),
					session.getAttribute("time").toString(),
					request.getParameter("duration"),EerrorMsgs);
			session.setAttribute("errorMsgs",EerrorMsgs);
			session.setAttribute("EVENT", event);
			if (EerrorMsgs.getErrorMsg().equals("")) {
				EventDAO.registerEvent(event);
				session.removeAttribute("errorMsgs");
				url = "/PayDeposit.jsp";
			}
		}
		else if(action.equalsIgnoreCase("payDeposit"))
        {
			EventErrorMsgs CarderrorMsgs = new EventErrorMsgs();
        	//Event event = new Event();	
        	event = (Event) session.getAttribute("EVENT");
        	String ccnumber = request.getParameter("idccNum");
        	String ccseccode = request.getParameter("idinvalidpin");
        	String expdate = request.getParameter("idexpDate");
        	event.setccnumber(ccnumber);
        	event.setccpin(ccseccode);
        	event.setccexpdate(expdate);
        	try {
				event.validateCardinfo(event, CarderrorMsgs);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	session.setAttribute("CardErrors", CarderrorMsgs);
        	String depositAmount = session.getAttribute("DepositValue").toString();
        	if (CarderrorMsgs.getErrorMsg().equals("")) 
        	{
        	EventDAO.UpdateRequest(event.getuserid(), event.getdate(), event.getstartTime(), event.gethallName(), 
        	ccnumber, ccseccode, expdate,depositAmount);
        	url = "/PayDeposit.jsp";
        	session.removeAttribute("DepositValue");
        	}
        	url = "/PayDeposit.jsp";
        }
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
