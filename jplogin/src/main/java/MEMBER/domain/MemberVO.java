package MEMBER.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("MemberVO")
public class MemberVO {	
	
	private String M_ID;	
	private String M_NAME;	
	private String M_PASSWORD;    
	private String M_EMAIL;	
	private String M_ADDRESS;	
	private String phnum;
	private String M_PHONE;
	private String M_BCODE;
	private String M_ACCOUNT;		
	private String M_REGISTRATION;
	private String M_DIVISION;
	private Date M_JOINDATE;
	private Date M_SECESSIONDATE;
	private String M_EMAILCHECK;
	
	

	public MemberVO() {
		
	}
	
	

	public MemberVO(String m_ID, String m_NAME, String m_PASSWORD, String m_EMAIL, String m_ADDRESS, String m_PHONE,
			String m_BCODE, String m_ACCOUNT, String m_REGISTRATION, String m_EMAILCHECK) {
		super();
		M_ID = m_ID;
		M_NAME = m_NAME;
		M_PASSWORD = m_PASSWORD;
		M_EMAIL = m_EMAIL;
		M_ADDRESS = m_ADDRESS;
		M_PHONE = m_PHONE;
		M_BCODE = m_BCODE;
		M_ACCOUNT = m_ACCOUNT;
		M_REGISTRATION = m_REGISTRATION;
		M_EMAILCHECK = m_EMAILCHECK;
	}	
	
	public MemberVO(String m_ID, String m_NAME, String m_PASSWORD, String m_EMAIL, String m_ADDRESS, String m_PHONE,
			String m_BCODE, String m_ACCOUNT, String m_EMAILCHECK) {
		super();
		M_ID = m_ID;
		M_NAME = m_NAME;
		M_PASSWORD = m_PASSWORD;
		M_EMAIL = m_EMAIL;
		M_ADDRESS = m_ADDRESS;
		M_PHONE = m_PHONE;
		M_BCODE = m_BCODE;
		M_ACCOUNT = m_ACCOUNT;
		M_EMAILCHECK = m_EMAILCHECK;
	}



	public String getM_ID() {
		return M_ID;
	}



	public void setM_ID(String m_ID) {
		M_ID = m_ID;
	}



	public String getM_NAME() {
		return M_NAME;
	}



	public void setM_NAME(String m_NAME) {
		M_NAME = m_NAME;
	}



	public String getM_PASSWORD() {
		return M_PASSWORD;
	}



	public void setM_PASSWORD(String m_PASSWORD) {
		M_PASSWORD = m_PASSWORD;
	}



	public String getM_EMAIL() {
		return M_EMAIL;
	}



	public void setM_EMAIL(String m_EMAIL) {
		M_EMAIL = m_EMAIL;
	}



	public String getM_ADDRESS() {
		return M_ADDRESS;
	}



	public void setM_ADDRESS(String m_ADDRESS) {
		M_ADDRESS = m_ADDRESS;
	}



	public String getPhnum() {
		return phnum;
	}



	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}



	public String getM_PHONE() {
		return M_PHONE;
	}



	public void setM_PHONE(String m_PHONE) {
		M_PHONE = m_PHONE;
	}



	public String getM_BCODE() {
		return M_BCODE;
	}



	public void setM_BCODE(String m_BCODE) {
		M_BCODE = m_BCODE;
	}



	public String getM_ACCOUNT() {
		return M_ACCOUNT;
	}



	public void setM_ACCOUNT(String m_ACCOUNT) {
		M_ACCOUNT = m_ACCOUNT;
	}



	public String getM_REGISTRATION() {
		return M_REGISTRATION;
	}



	public void setM_REGISTRATION(String m_REGISTRATION) {
		M_REGISTRATION = m_REGISTRATION;
	}



	public String getM_DIVISION() {
		return M_DIVISION;
	}



	public void setM_DIVISION(String m_DIVISION) {
		M_DIVISION = m_DIVISION;
	}



	public Date getM_JOINDATE() {
		return M_JOINDATE;
	}



	public void setM_JOINDATE(Date m_JOINDATE) {
		M_JOINDATE = m_JOINDATE;
	}



	public Date getM_SECESSIONDATE() {
		return M_SECESSIONDATE;
	}



	public void setM_SECESSIONDATE(Date m_SECESSIONDATE) {
		M_SECESSIONDATE = m_SECESSIONDATE;
	}



	public String getM_EMAILCHECK() {
		return M_EMAILCHECK;
	}



	public void setM_EMAILCHECK(String m_EMAILCHECK) {
		M_EMAILCHECK = m_EMAILCHECK;
	}	

	
	
	
}
