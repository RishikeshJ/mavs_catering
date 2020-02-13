package masv_catering.model;

public class EventErrorMsgs {

	private String errorMsg;
	private String duplicateResMsg;
	private String invalidCCNum;
	private String invalidpin;
	private String invalidExpDate;
	private String timeerror;
	private String capacityError;
	private String durationError;
	private String pastdateError;
	private String eventNameError;
	
	public EventErrorMsgs () {
		this.errorMsg="";
		this.duplicateResMsg="";
		this.invalidCCNum="";
		this.invalidpin="";
		this.invalidExpDate = "";
		this.timeerror = "";
		this.capacityError="";
		this.durationError="";
		this.pastdateError="";
		this.eventNameError="";
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg() {
		if (!duplicateResMsg.equals("")
				||!invalidCCNum.equals("")
				||!invalidpin.equals("")
				||!invalidExpDate.equals("")
				||!timeerror.equals("")
				||!capacityError.equals("")
				||!durationError.equals("")
				||!pastdateError.equals("")
				||!eventNameError.equals(""))
		  errorMsg="Please correct the following errors";
	}
	
	public String getduplicateResMsg() {
		return duplicateResMsg;
	}

	public void setduplicateResMsg(String duplicateResMsg) {
		this.duplicateResMsg = duplicateResMsg;
	}

	public String getinvalidCCNum() {
		return invalidCCNum;
	}

	public void setinvalidCCNum(String invalidCCNum) {
		this.invalidCCNum = invalidCCNum;
	}
	
	public String getinvalidpin() {
		return invalidpin;
	}

	public void setinvalidpin(String invalidpin) {
		this.invalidpin = invalidpin;
	}
	
	public String getinvalidExpDate() {
		return invalidExpDate;
	}

	public void setinvalidExpDate(String invalidExpDate) {
		this.invalidExpDate = invalidExpDate;
	}
	
	public String gettimeerror() {
		return timeerror;
	}

	public void settimeerror(String timeerror) {
		this.timeerror = timeerror;
	}
	
	public String getcapacityError() {
		return capacityError;
	}

	public void setcapacityError(String capacityError) {
		this.capacityError = capacityError;
	}
	
	public String getdurationError() {
		return durationError;
	}

	public void setdurationError(String durationError) {
		this.durationError = durationError;
	}
	
	public String getpastdateError() {
		return pastdateError;
	}

	public void setpastdateError(String pastdateError) {
		this.pastdateError = pastdateError;
	}
	
	public String geteventNameError() {
		return eventNameError;
	}

	public void seteventNameError(String eventNameError) {
		this.eventNameError = eventNameError;
	}

}
