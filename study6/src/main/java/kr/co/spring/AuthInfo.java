package kr.co.spring;


public class AuthInfo {
	
	private String id;
	private String email;
	private String division;
	private String emailCheck;
	
	public AuthInfo(String id, String email, String division, String emailCheck) {
		
		this.id = id;
		this.email = email;
		this.division = division;
		this.emailCheck = emailCheck;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getEmailCheck() {
		return emailCheck;
	}

	public void setEmailCheck(String emailCheck) {
		this.emailCheck = emailCheck;
	}	
}

