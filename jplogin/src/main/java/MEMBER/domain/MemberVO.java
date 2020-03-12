package MEMBER.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Alias("MemberVO")
public class MemberVO {	
	
	private String MID;	
	private String MNAME;	
	private String MPASSWORD;    
	private String MEMAIL;	
	private String MADDRESS;	
	private String phnum;
	private String MPHONE;
	private String MBCODE;
	private String MACCOUNT;		
	private String MREGISTRATION;
	private String MDIVISION;
	private Date MJOINDATE;
	private Date MSECESSIONDATE;
	private String MEMAILCHECK;
	
	

	public MemberVO() {
		
	}
	
	

	public MemberVO(String mID, String mNAME, String mPASSWORD, String mEMAIL, String mADDRESS, String mPHONE,
			String mBCODE, String mACCOUNT, String mREGISTRATION, String mEMAILCHECK) {
		super();
		MID = mID;
		MNAME = mNAME;
		MPASSWORD = mPASSWORD;
		MEMAIL = mEMAIL;
		MADDRESS = mADDRESS;
		MPHONE = mPHONE;
		MBCODE = mBCODE;
		MACCOUNT = mACCOUNT;
		MREGISTRATION = mREGISTRATION;
		MEMAILCHECK = mEMAILCHECK;
	}	
	
	public MemberVO(String mID, String mNAME, String mPASSWORD, String mEMAIL, String mADDRESS, String mPHONE,
			String mBCODE, String mACCOUNT, String mEMAILCHECK) {
		super();
		MID = mID;
		MNAME = mNAME;
		MPASSWORD = mPASSWORD;
		MEMAIL = mEMAIL;
		MADDRESS = mADDRESS;
		MPHONE = mPHONE;
		MBCODE = mBCODE;
		MACCOUNT = mACCOUNT;
		MEMAILCHECK = mEMAILCHECK;
	}



	public String getMID() {
		return MID;
	}



	public void setMID(String mID) {
		MID = mID;
	}



	public String getMNAME() {
		return MNAME;
	}



	public void setMNAME(String mNAME) {
		MNAME = mNAME;
	}



	public String getMPASSWORD() {
		return MPASSWORD;
	}



	public void setMPASSWORD(String mPASSWORD) {
		MPASSWORD = mPASSWORD;
	}



	public String getMEMAIL() {
		return MEMAIL;
	}



	public void setMEMAIL(String mEMAIL) {
		MEMAIL = mEMAIL;
	}



	public String getMADDRESS() {
		return MADDRESS;
	}



	public void setMADDRESS(String mADDRESS) {
		MADDRESS = mADDRESS;
	}



	public String getPhnum() {
		return phnum;
	}



	public void setPhnum(String phnum) {
		this.phnum = phnum;
	}



	public String getMPHONE() {
		return MPHONE;
	}



	public void setMPHONE(String mPHONE) {
		MPHONE = mPHONE;
	}



	public String getMBCODE() {
		return MBCODE;
	}



	public void setMBCODE(String mBCODE) {
		MBCODE = mBCODE;
	}



	public String getMACCOUNT() {
		return MACCOUNT;
	}



	public void setMACCOUNT(String mACCOUNT) {
		MACCOUNT = mACCOUNT;
	}



	public String getMREGISTRATION() {
		return MREGISTRATION;
	}



	public void setMREGISTRATION(String mREGISTRATION) {
		MREGISTRATION = mREGISTRATION;
	}



	public String getMDIVISION() {
		return MDIVISION;
	}



	public void setMDIVISION(String mDIVISION) {
		MDIVISION = mDIVISION;
	}



	public Date getMJOINDATE() {
		return MJOINDATE;
	}



	public void setMJOINDATE(Date mJOINDATE) {
		MJOINDATE = mJOINDATE;
	}



	public Date getMSECESSIONDATE() {
		return MSECESSIONDATE;
	}



	public void setMSECESSIONDATE(Date mSECESSIONDATE) {
		MSECESSIONDATE = mSECESSIONDATE;
	}



	public String getMEMAILCHECK() {
		return MEMAILCHECK;
	}



	public void setMEMAILCHECK(String mEMAILCHECK) {
		MEMAILCHECK = mEMAILCHECK;
	}	

	
	
	
}

