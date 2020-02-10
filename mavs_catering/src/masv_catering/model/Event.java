package masv_catering.model;

import java.io.Serializable;

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
	private String ccsecuritycode;
	private String ccexpdate;
	
	public void setEvent(String lastName,String firstName, String date,String startTime,String duration,String hallName,String estAttendees,
			String eventName, String foodType,String meal, String mealFormality, String drinkType, String entertainmentItems,String eventStatus, String eventID,
			String ccnumber,String ccsecuritycode, String ccexpdate) 
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
		this.ccsecuritycode = ccsecuritycode;
		this.ccexpdate = ccexpdate;

	}
	
	public void updateEvent(String lastName,String firstName, String date,String startTime,String duration,String hallName,String estAttendees,
			String eventName, String foodType,String meal, String mealFormality, String drinkType, String entertainmentItems,String eventStatus,String eventID,
			String ccnumber,String ccsecuritycode, String ccexpdate) 
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
		this.ccsecuritycode = ccsecuritycode;
		this.ccexpdate = ccexpdate;
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
	
	public String getccsecuritycode() {
		return ccsecuritycode;
	}

	public void setccsecuritycode(String ccsecuritycode) {
		this.ccsecuritycode = ccsecuritycode;
	}

	public String getccexpdate() {
		return ccexpdate;
	}

	public void setccexpdate(String ccexpdate) {
		this.ccexpdate = ccexpdate;
	}



}
