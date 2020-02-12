package mavs_catering.data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import masv_catering.model.Event;
import masv_catering.model.User;
import mavs_catering.util.SQLConnection;

public class EventDAO {
static SQLConnection DBMgr = SQLConnection.getInstance();
public static void registerEvent(Event event) {
	Statement stmt = null;   
	Connection conn = SQLConnection.getDBConnection();  
	String registerUser = "INSERT INTO EVENTDETAILS (lastName, firstName, date, startTime, duration, hallName, "
			+ "estAttendees, eventName, foodType, meal, mealFormality, drinkType, entertainmentItems, eventStatus,userid,ccnum,cvvnum,expdate) ";					
	registerUser += " VALUES ('"  
			+ event.getLastName()+ "','"
			+ event.getfirstName()+ "','"		
			+ event.getdate() + "','"
			+ event.getstartTime()+ "','" 
			+ event.getduration()+ "','"
			+ event.gethallName()+ "',"
			+ event.getestAttendees()+ ",'"		
			+ event.geteventName()+ "','"
			+ event.getfoodType()+ "','"
			+ event.getmeal()+ "','"
			+ event.getmealFormality()+ "','"
			+ event.getdrinkType()+ "','"
			+ event.getentertainmentItems()+ "','"
			+ event.geteventStatuss()+ "','"
			+ event.getuserid()+ "','"
			+ event.getccnumber()+ "','"
			+ event.getccsecuritycode()+ "','"
			+ event.getccexpdate()+ "')" ;
	System.out.println("Query: "+registerUser);
	
	try {   
	conn = SQLConnection.getDBConnection();  
	conn.setAutoCommit(false);   
	stmt = conn.createStatement();
	stmt.executeUpdate(registerUser);
	System.out.println(registerUser);
	conn.commit();					 
} catch (SQLException sqle) { 
	System.out.println(sqle.toString());
	sqle.printStackTrace();
} finally {
	try {
		conn.close();
		stmt.close();
	} catch (SQLException e) {
		e.printStackTrace();
	};
}

}

private static ArrayList<Event> ReturnPendingEventList (String queryString) {
	System.out.println("db manager"+DBMgr);
	ArrayList<Event> PendingEventsinDB= new ArrayList<Event>();
	
	Statement stmt = null;
	Connection conn = SQLConnection.getDBConnection(); 
	try {
		stmt = conn.createStatement();
		ResultSet eventList = stmt.executeQuery(queryString);
		while (eventList.next()) {
			Event event = new Event(); 
			event.setLastName(eventList.getString("lastName"));
			event.setfirstName(eventList.getString("firstName"));
			event.setdate(eventList.getString("date"));
			event.setstartTime(eventList.getString("startTime"));  
			event.setduration(eventList.getString("duration"));
			event.sethallName(eventList.getString("hallName"));
			event.setestAttendees(eventList.getString("estAttendees"));
			event.seteventName(eventList.getString("eventName"));
			event.setfoodType(eventList.getString("foodType"));
			
			event.setmeal(eventList.getString("meal"));
			event.setmealFormality(eventList.getString("mealFormality"));
			event.setdrinkType(eventList.getString("drinkType"));
			event.setentertainmentItems(eventList.getString("entertainmentItems"));
			event.seteventStatus(eventList.getString("eventStatus"));
			
			event.seteventID(eventList.getString("eventID"));
			
			PendingEventsinDB.add(event);	
		}
	} catch (SQLException e) {}
	return PendingEventsinDB;
}

public static ArrayList<Event> listEvents() {
	// TODO Auto-generated method stub
	return ReturnPendingEventList("SELECT * from eventdetails where eventStatus = 'Pending'");
}

public static void UpdateRequest(String userid, String date, String time, String hallname, String ccnum, String cvvnum, String expdate, String depositAmount) {
	Statement stmt = null;
	Connection conn = SQLConnection.getDBConnection();
	String Status = "Reservered";
	try
	{
		stmt = conn.createStatement();
		conn.setAutoCommit(false);
		String editUser = "UPDATE mavs_catering.eventdetails SET eventStatus = '"+Status+"', ccnum = '"+ccnum+"',"
				+ " cvvnum = '"+cvvnum+"',"
				+ "expdate = '"+expdate+"' "
				+ "depositAmount = '"+depositAmount+"' "
				+ "WHERE userid = '"+userid+"' and date = '"+date+"' and startTime = '"+time+"' and hallName = '"+hallname+"'";
		System.out.println(editUser);
		stmt.executeUpdate(editUser);	
		conn.commit();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
}

public static int CheckReservations(String date, String time, String hallname) {
	Statement stmt = null;
	Connection conn = SQLConnection.getDBConnection();
	String count = "0";
	try
	{
		stmt = conn.createStatement();
		conn.setAutoCommit(false);
		String reservations = "select count(*) as count from eventdetails "
				+ "WHERE date = '"+date+"' and startTime = '"+time+"' and hallName = '"+hallname+"'";
		System.out.println(reservations);
		ResultSet Result = stmt.executeQuery(reservations);	
		while(Result.next()) {count = Result.getString("count");}
		
		conn.commit();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return Integer.parseInt(count);
}

public static String getlastname(String userid) {
	Statement stmt = null;
	Connection conn = SQLConnection.getDBConnection();
	String lastName = "";
	try
	{
		stmt = conn.createStatement();
		conn.setAutoCommit(false);
		String reservations = "select lastName from User "
				+ "WHERE username = '"+userid+"'";
		System.out.println(reservations);
		ResultSet Result = stmt.executeQuery(reservations);	
		while(Result.next()) {lastName = Result.getString("lastName");}
		
		conn.commit();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return lastName;
}

public static String getfirstname(String userid) {
	Statement stmt = null;
	Connection conn = SQLConnection.getDBConnection();
	String lastName = "";
	try
	{
		stmt = conn.createStatement();
		conn.setAutoCommit(false);
		String reservations = "select firstName from User "
				+ "WHERE username = '"+userid+"'";
		System.out.println(reservations);
		ResultSet Result = stmt.executeQuery(reservations);	
		while(Result.next()) {lastName = Result.getString("firstName");}
		
		conn.commit();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return lastName;
}


public static Event getSpecificEvent(String eventID) {
	Statement stmt = null;   
	Connection conn = null;  
	Event event = new Event();
	try {   
		conn = SQLConnection.getDBConnection();  
		stmt = conn.createStatement();
		String searchSpecificEvent = " SELECT * from eventdetails WHERE eventID = '"+eventID+"'";
		ResultSet eventList = stmt.executeQuery(searchSpecificEvent);
		while(eventList.next()) {
			String lastName = eventList.getString("lastName");
			String firstName  = eventList.getString("firstName");
			String date = eventList.getString("date");
			String startTime  = eventList.getString("startTime");
			String duration  = eventList.getString("duration");
			String hallName = eventList.getString("hallName");
			String estAttendees  = eventList.getString("estAttendees");
			String eventName  = eventList.getString("eventName");
			String foodType  = eventList.getString("foodType");
			String meal  = eventList.getString("meal");
			String mealFormality = eventList.getString("mealFormality");
			String drinkType  = eventList.getString("drinkType");
			String entertainmentItems  = eventList.getString("entertainmentItems");
			String eventStatus  = eventList.getString("eventStatus");
			String EventID  = eventID;
			event.setEvent(lastName, firstName, date, startTime, duration, hallName, estAttendees, eventName, foodType, meal, mealFormality, drinkType, entertainmentItems, eventStatus, eventID);
		}
		
		} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		};
	return event;
}

}
	
