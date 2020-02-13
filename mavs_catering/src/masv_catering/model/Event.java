package masv_catering.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpSession;


import com.mysql.cj.Session;

import mavs_catering.data.EventDAO;

public class Event implements Serializable{
	private static final long serialVersionUID = 2L;
	
	private String lastName;
	private String firstName;
	private String date;
	private String startTime;
	private String duration;
	private String hallName;
	private String estAttendees;
	private String eventName;
	private String foodType;
	private String meal;
	private String mealFormality;
	private String drinkType;
	private String entertainmentItems;
	private String eventStatus;
	private String eventID;
	private String ccnumber;
	private String ccpin;
	private String ccexpdate;
	private String userid;
	private String depositAmount;
	
	public void setEvent(String lastName,String firstName, String date,String startTime,String duration,String hallName,String estAttendees,
			String eventName, String foodType,String meal, String mealFormality, String drinkType, String entertainmentItems,String eventStatus, String eventID,
			String ccnumber,String ccpin, String ccexpdate, String userid, String depositAmount) 
	{	
		//System.out.println(username+" : "+role+": "+firstName);
		this.lastName = lastName;
		this.firstName = firstName;
		this.date = date;
		this.startTime = startTime;
		this.duration = duration;
		this.hallName = hallName;
		this.estAttendees = estAttendees;
		this.eventName = eventName;
		this.foodType = foodType;
		this.meal = meal;
		this.mealFormality = mealFormality;
		this.drinkType = drinkType;
		this.entertainmentItems = entertainmentItems;
		this.eventStatus = eventStatus;
		this.eventID = eventID;
		this.ccnumber = ccnumber;
		this.ccpin = ccpin;
		this.ccexpdate = ccexpdate;
		this.userid = userid;
		this.depositAmount = depositAmount;

	}
	
	public void updateEvent(String lastName,String firstName, String date,String startTime,String duration,String hallName,String estAttendees,
			String eventName, String foodType,String meal, String mealFormality, String drinkType, String entertainmentItems,String eventStatus,String eventID,
			String ccnumber,String ccpin, String ccexpdate, String userid, String depositAmount) 
	{	
		this.lastName = lastName;
		this.firstName = firstName;
		this.date = date;
		this.startTime = startTime;
		this.duration = duration;
		this.hallName = hallName;
		this.estAttendees = estAttendees;
		this.eventName = eventName;
		this.foodType = foodType;
		this.meal = meal;
		this.mealFormality = mealFormality;
		this.drinkType = drinkType;
		this.entertainmentItems = entertainmentItems;
		this.eventStatus = eventStatus;
		this.eventID = eventID;
		this.ccnumber = ccnumber;
		this.ccpin = ccpin;
		this.ccexpdate = ccexpdate;
		this.userid = userid;
		this.depositAmount = depositAmount;
	}
	
	public String geteventID() {
		return eventID;
	}

	public void seteventID(String eventID) {
		this.eventID = eventID;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}
	
	public String getstartTime() {
		return startTime;
	}

	public void setstartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getduration() {
		return duration;
	}

	public void setduration(String duration) {
		this.duration = duration;
	}

	public String gethallName() {
		return hallName;
	}

	public void sethallName(String hallName) {
		this.hallName = hallName;
	}

	public String getestAttendees() {
		return estAttendees;
	}

	public void setestAttendees(String estAttendees) {
		this.estAttendees = estAttendees;
	}
	

	public String geteventName() {
		return eventName;
	}

	public void seteventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getfoodType() {
		return foodType;
	}

	public void setfoodType(String foodType) {
		this.foodType = foodType;
	}
	
	public String getmeal() {
		return meal;
	}

	public void setmeal(String meal) {
		this.meal = meal;
	}
	
	public String getmealFormality() {
		return mealFormality;
	}

	public void setmealFormality(String mealFormality) {
		this.mealFormality = mealFormality;
	}
	
	public String getdrinkType() {
		return drinkType;
	}

	public void setdrinkType(String drinkType) {
		this.drinkType = drinkType;
	}
	
	public String getentertainmentItems() {
		return entertainmentItems;
	}

	public void setentertainmentItems(String entertainmentItems) {
		this.entertainmentItems = entertainmentItems;
	}
	
	public String geteventStatuss() {
		return eventStatus;
	}

	public void seteventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}

	public String getccnumber() {
		return ccnumber;
	}

	public void setccnumber(String ccnumber) {
		this.ccnumber = ccnumber;
	}
	
	public String getccpin() {
		return ccpin;
	}

	public void setccpin(String ccpin) {
		this.ccpin = ccpin;
	}

	public String getccexpdate() {
		return ccexpdate;
	}

	public void setccexpdate(String ccexpdate) {
		this.ccexpdate = ccexpdate;
	}
	
	public String getuserid() {
		return userid;
	}

	public void setuserid(String userid) {
		this.userid = userid;
	}
	
	public String getdepositAmount() {
		return depositAmount;
	}

	public void setdepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

//Validations depositAmount
	public void validateEvent (Event event, EventErrorMsgs errorMsgs){
		//if (action.equals("register")) {
		errorMsgs.setduplicateResMsg(verifyFacilityAvailability(event.getdate(),event.getstartTime(),event.gethallName()));
		errorMsgs.setcapacityError(verifyHallCapacity(event.gethallName(), event.getestAttendees()));
		errorMsgs.seteventNameError(validateEventName(event.geteventName().toString(), errorMsgs));
		errorMsgs.setErrorMsg();
	}
	
	public String validateEventName(String eventName, EventErrorMsgs errorMsgs) {
		String Error = "";
		if(!Character.isUpperCase(eventName.charAt(0))){
			Error = "Event name must start with a capital letter";
		}
		else if(eventName.length()<2 || eventName.length() > 30) {
			Error = "Event name length must be >2 and <30";
		}
		else if(eventName.isEmpty())
		{
			Error = "Event name cannot be empty";
		}
		return Error;
	}
	
	public void validateselectedDate (String selecteddate, EventErrorMsgs errorMsgs) throws ParseException {
		errorMsgs.setpastdateError(verifyifReservationInPast(selecteddate));
		errorMsgs.setErrorMsg();
	}
	
	public void validateduration (String selecteddate, String selectedtime, String Duration, EventErrorMsgs errorMsgs) {
		//if (action.equals("register")) {
		errorMsgs.setdurationError(validateeventduration(selecteddate,selectedtime,Duration));
		errorMsgs.setErrorMsg();
	}
	
	public void validateCardinfo(Event event, EventErrorMsgs errorMsgs) throws ParseException {
		errorMsgs.setinvalidCCNum(validateCCnumber(event.getccnumber()));
		errorMsgs.setinvalidpin(validatepin(event.getccpin()));
		errorMsgs.setinvalidExpDate(validateExpDate(event.getccexpdate()));
		errorMsgs.setErrorMsg();
	}
	
	public void validateSelectedDateTime(String date, String Time, EventErrorMsgs errorMsgs) {
		errorMsgs.settimeerror(validatedateandtime(date, Time));
		errorMsgs.setErrorMsg();
	}
	
	private String verifyFacilityAvailability(String date, String startTime, String hallName) {
		
		int result=EventDAO.CheckReservations(date, startTime, hallName);
		System.out.println(result);
		String Error="";
		if(result>0) {
			Error = "Hall is already reserved for this time slot, please try again";
		}else {
			Error = "";
		}
		return Error;
	} 
	
	private String verifyifReservationInPast(String date) throws ParseException {
		String Error = "";
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date selectedDate = sdformat.parse(date);
		Date currentDate = sdformat.parse(java.time.LocalDate.now().toString());
		if(selectedDate.compareTo(currentDate) < 0 ) {
			Error = "Date must not be in past";
		}		
		return Error;
	}
	
	private String verifyHallCapacity(String hallname, String estAttendees) {
		
		String Error = "";
		if(hallname.equals("Maverick") && Integer.parseInt(estAttendees) > 100) {
			Error = "Maveric Hall cannot have an estimated attendance greater than 100";
		}
		else if(hallname.equals("KC") && Integer.parseInt(estAttendees) > 25) {
			Error = "KC Hall cannot have an estimated attendance greater than 25";
		}
		else if(hallname.equals("Arlington") && Integer.parseInt(estAttendees) > 50) {
			Error = "Arlington Hall cannot have an estimated attendance greater than 50";
		}
		else if(hallname.equals("Shard") && Integer.parseInt(estAttendees) > 25) {
			Error = "Shard Hall cannot have an estimated attendance greater than 25";
		}
		else if(hallname.equals("Liberty") && Integer.parseInt(estAttendees) > 75) {
			Error = "Liberty cannot have an estimated attendance greater than 75";
		}
		else if(!isTextAnInteger(estAttendees)) {
			Error = "Estimated attendees must be a number";
		}
		else if(Integer.parseInt(estAttendees)>0) {
			Error = "Estimated attendees must be greater than 0";
		}
		else if(Integer.parseInt(estAttendees)<=100) {
			Error = "Estimated attendees must be <=100";
		}
		else if(estAttendees.isEmpty())
		{
			Error = "Estimated attendees cannot be empty";
		}
		
		return Error;
	}
	
	private String validatedateandtime(String selecteddate, String selectedtime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date SelectedDate = null;
		try {
			SelectedDate = sdf.parse(selecteddate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(SelectedDate);
		
		String selectedTimeext = selectedtime+":00";
	    Date time1 = null;
		try {
			time1 = new SimpleDateFormat("HH:mm:ss").parse(selectedTimeext);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar calendar1 = Calendar.getInstance();
	    calendar1.setTime(time1);
	    calendar1.add(Calendar.DATE, 1);
	    
	    //***Weekend Opening Time***
	    String weekendOpeningTime = "12:00:00";
	    Date time2 = null;
		try {
			time2 = new SimpleDateFormat("HH:mm:ss").parse(weekendOpeningTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar sundayopencal = Calendar.getInstance();
	    sundayopencal.setTime(time2);
	    sundayopencal.add(Calendar.DATE, 1);
	    
	    //***Weekeday Opening Time***
	    
	    String weekdayOpeningTime = "07:00:00";
	    Date time3 = null;
		try {
			time3 = new SimpleDateFormat("HH:mm:ss").parse(weekdayOpeningTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar weekdayopencal = Calendar.getInstance();
	    weekdayopencal.setTime(time3);
	    weekdayopencal.add(Calendar.DATE, 1);
	    
	    //***Weekday Closing Time***
	    String weekdayClosingTime = "23:00:00";
	    Date time4 = null;
		try {
			time4 = new SimpleDateFormat("HH:mm:ss").parse(weekdayClosingTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar weekdayclosecal = Calendar.getInstance();
	    weekdayclosecal.setTime(time4);
	    weekdayclosecal.add(Calendar.DATE, 1);
	    
	    //***Weekend Closing Time***
	    String weekendClosingtime = "02:00:00";
	    Date time5 = null;
		try {
			time5 = new SimpleDateFormat("HH:mm:ss").parse(weekendClosingtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar weekendclosecal = Calendar.getInstance();
	    weekendclosecal.setTime(time5);
	    weekendclosecal.add(Calendar.DATE, 1);
	    
	    Date x = calendar1.getTime();
	    String result="";
		//Validation : if its any day except Sunday and the time for request is less than 7am
	    if(cal.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY)
	    	{
	    	if(x.before(weekdayopencal.getTime())
	    		|| x.after(weekdayclosecal.getTime())) {
	    		result = "Halls are open from 7am to 11pm on all days except Sunday, Please select a different time";
	    	}	    	
	    }
	    
	    //Validation : if its a weekend and the time of request is less than noon
		if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			if(x.before(sundayopencal.getTime())
				|| x.after(weekendclosecal.getTime()))
			{
				result = "Halls are open from 12pm to 2am Sunday, Please select a different time";
			}
		
		}	  
		

	    //Validation : if its a weekend and the time of request is less than noon
		if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			if(x.before(weekdayopencal.getTime())
				|| x.after(weekendclosecal.getTime()))
			{
				result = "Halls are open from 7am to 2am on Saturday, Please select a different time";
			}
		}
		return result;
	}
	
	private String validateeventduration(String selecteddate, String selectedtime, String Duration) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date SelectedDate = null;
		try {
			SelectedDate = sdf.parse(selecteddate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		Calendar cal = Calendar.getInstance();
		cal.setTime(SelectedDate);
		
		String selectedTimeext = selectedtime+":00";
	    Date time1 = null;
		try {
			time1 = new SimpleDateFormat("HH:mm:ss").parse(selectedTimeext);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar calendar1 = Calendar.getInstance();
	    calendar1.setTime(time1);
	    calendar1.add(Calendar.DATE, 1);
	    
	    //***Weekend Opening Time***
	    String weekendOpeningTime = "12:00:00";
	    Date time2 = null;
		try {
			time2 = new SimpleDateFormat("HH:mm:ss").parse(weekendOpeningTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar sundayopencal = Calendar.getInstance();
	    sundayopencal.setTime(time2);
	    sundayopencal.add(Calendar.DATE, 1);
	    
	    //***Weekeday Opening Time***
	    
	    String weekdayOpeningTime = "07:00:00";
	    Date time3 = null;
		try {
			time3 = new SimpleDateFormat("HH:mm:ss").parse(weekdayOpeningTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar weekdayopencal = Calendar.getInstance();
	    weekdayopencal.setTime(time3);
	    weekdayopencal.add(Calendar.DATE, 1);
	    
	    //***Weekday Closing Time***
	    String weekdayClosingTime = "23:00:00";
	    Date time4 = null;
		try {
			time4 = new SimpleDateFormat("HH:mm:ss").parse(weekdayClosingTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar weekdayclosecal = Calendar.getInstance();
	    weekdayclosecal.setTime(time4);
	    weekdayclosecal.add(Calendar.DATE, 1);
	    
	    //***Weekend Closing Time***
	    String weekendClosingtime = "02:00:00";
	    Date time5 = null;
		try {
			time5 = new SimpleDateFormat("HH:mm:ss").parse(weekendClosingtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Calendar weekendclosecal = Calendar.getInstance();
	    weekendclosecal.setTime(time5);
	    weekendclosecal.add(Calendar.DATE, 1);
	    

	    Calendar Durationtime = Calendar.getInstance();
	    Durationtime.add(Calendar.HOUR_OF_DAY, Integer.parseInt(duration));
	    int duration = Durationtime.get(Calendar.HOUR_OF_DAY);
	    int StartTimehr = calendar1.get(Calendar.HOUR_OF_DAY);
	    int StartTimemin = calendar1.get(Calendar.MINUTE);
	    
	    int StartTimeinMins = StartTimehr * 60 + StartTimemin;	    
 	    int durationinMins = Integer.parseInt(Duration)* 60;
 	    int TotalDuration = StartTimeinMins + durationinMins;
 	    //***Weekday Closing Time***
 	    if(StartTimeinMins + durationinMins > 1380 )
 	    {
 	    	String Error = "Duration cannot exceed close time";
 	    	System.out.println(Error);
 	    }
	    
	    //System.out.println(temp3);
	    //weekday close cal "23:00:00"
	    
	    String result="";
		//Validation : if its any day except Sunday and the time for request is less than 7am
	    if(cal.get(Calendar.DAY_OF_WEEK)!=Calendar.SUNDAY && cal.get(Calendar.DAY_OF_WEEK)!=Calendar.SATURDAY)
	    	{
	    	if(TotalDuration > 1380) {
	    		result = "Duration cannot exceed close time";
	    	}	    	
	    }
	    
	    //Validation : if its a weekend and the time of request is less than noon
		if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			if(TotalDuration > 1560)
			{
				result = "Duration cannot exceed close time";
			}
		}	  
		return result;
	}
	
	
	private String validateCCnumber(String ccnum) {
		ccnum = ccnum.trim();
		String result="";
		if (ccnum.isEmpty())
			result= "Your Credit Card Number cannot be empty";
		else
			if (!isTextAnInteger(ccnum))
				result="Credit Card Number field must be a number";
			else
				if (ccnum.length()!=16){
					result="Credit card number must be 16 digits";
				}
		return result;
	}
	
	private String validatepin(String pin) {
		pin = pin.trim();
		String result="";
		if (pin.isEmpty())
			result= "Credit card pin cannot be empty";
		else
			if (!isTextAnInteger(pin))
				result="Credit card pin must be a number";
			else
				if(pin.length()!=4)
					result="Credit card pin must be 4 digits";
		return result;
	}
	
	private String validateExpDate(String expdate) throws ParseException {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		Date ExpDate = sdformat.parse(expdate);
		Date currentDate = sdformat.parse(java.time.LocalDate.now().toString());
		expdate = expdate.trim();
		String result="";
		if (expdate.isEmpty())
			result= "Your Expiry date field cannot be empty";
		else if(ExpDate.compareTo(currentDate) < 0 ) {
				result = "Credit card exp date must not be in past";
		}		
		return result;
	}
	
	private boolean isTextAnInteger (String string) {
        boolean result;
		try
        {
            Long.parseLong(string);
            result=true;
        } 
        catch (NumberFormatException e) 
        {
            result=false;
        }
		return result;
	}


}
