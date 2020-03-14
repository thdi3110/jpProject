package member.controller;

public class LoginCommand {

	private String MID;
	private String MPASSWORD;
	
	
	
	public LoginCommand() {		
	}



	public LoginCommand(String mID, String mPASSWORD) {		
		MID = mID;
		MPASSWORD = mPASSWORD;
	}



	public String getMID() {
		return MID;
	}



	public void setMID(String mID) {
		MID = mID;
	}



	public String getMPASSWORD() {
		return MPASSWORD;
	}



	public void setMPASSWORD(String mPASSWORD) {
		MPASSWORD = mPASSWORD;
	}
	
	
	
	
}
