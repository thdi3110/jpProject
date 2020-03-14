package member.service;


import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import member.dao.MemberDao;
import member.domain.MemberVO;
import member.mail.SendMail;
import member.seed.KISA_SEED;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	private SendMail sm;
	
	@Autowired
	private KISA_SEED seed;
	
	
	public void setSeed(KISA_SEED seed) {
		this.seed = seed;
	}	
	
	
	public void setPwdEncoder(BCryptPasswordEncoder pwdEncoder) {
		this.pwdEncoder = pwdEncoder;
	}	

	
	public void setSm(SendMail sm) {
		this.sm = sm;
	}
	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}	
	
	public void writeNormal(MemberVO memberVO, String password, String email, String phnum, String phone, String account) {
		
		String pass = pwdEncoder.encode(password);
		memberVO.setMPASSWORD(pass);
		
		String phones = phnum + "-" + phone;
		memberVO.setMPHONE(phones);
		
		if (account != null) {			
			try {
				String seedAccount = seed.encrypt(account);
				memberVO.setMACCOUNT(account);				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		String code = Integer.toString((int) ((Math.random()*999999)+100000));
		sm.sendmail(email, code);
		memberVO.setMEMAILCHECK(code);
		
		memberDao.insertNormal(memberVO);
	}
	
	public void writeParcelOut(MemberVO memberVO, String password, String email, String phnum, String phone, String account) {
		
		String pass = pwdEncoder.encode(password);
		memberVO.setMPASSWORD(pass);
		
		String phones = phnum + "-" + phone;
		memberVO.setMPHONE(phones);
		
		if (account != null) {			
			try {
				String seedAccount = seed.encrypt(account);
				memberVO.setMACCOUNT(account);				
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		String code = Integer.toString((int) ((Math.random()*999999)+100000));
		sm.sendmail(email, code);
		memberVO.setMEMAILCHECK(code);
		
		memberDao.insertParcelOut(memberVO);
	}
	
	public void emailAuthentication(String MEMAILCHECK) {
		memberDao.updateEmailAuthentication(MEMAILCHECK);
	}
	
	public int idCheck(String MID) {
		int result = memberDao.idCheck(MID);
		return result;
	}
	
	public int regCheck(String MREGISTRATION) {
		int result = memberDao.regCheck(MREGISTRATION);
		return result;
	}
	
	public int emailChk(String MEMAILCHECK) {
		int result = memberDao.emailChk(MEMAILCHECK);
		
		return result;
	}
	
	public String sendEmail(String MID) {		
		MemberVO member = memberDao.sendEmail(MID);
		int result = 0;
		if(member==null) {
			result = 0;
			return Integer.toString(result);
		}
		String email = member.getMEMAIL();
		String emailCheck = member.getMEMAILCHECK();
		
		if(emailCheck.equals("Y")) {
			 result = 2;
			return Integer.toString(result);
		}
		
		String code = Integer.toString((int) ((Math.random()*999999)+100000));
		
		memberDao.updateEmailCode(code, email);
		sm.sendmail(email, code);		
		result = 1;
		
		return Integer.toString(result);
	}
	
	public String loginCheck(String id, String matchPassword) {
		System.out.println(id);
		MemberVO member = memberDao.loginCheck(id);	
		
		System.out.println(matchPassword);
		int result = 0;		
		if(member == null) {
			result = 0;
			return Integer.toString(result);
		}
		String oldPassword = member.getMPASSWORD();
		String emailCheck = member.getMEMAILCHECK();
		
		if(!pwdEncoder.matches(matchPassword,oldPassword)) {
			 result = 0;
		}else if(!emailCheck.equals("Y")){
			 result = 1;
		}else {
			 result = 2;
		}
		return Integer.toString(result);
		
	}
	
	public MemberVO findPassword(String id, String email) {
		MemberVO result = memberDao.findPassword(id, email);
		return result;
	}
	
	
	public int updateEmailCode(String code , String email) {
		int result = memberDao.updateEmailCode(code, email);
		return result;
	}
	
	public int findIdEmailCheck(String email) {
		int result = memberDao.findIdEmailCheck(email);
		return result;
	}
	
	public MemberVO findId(String email) {
		MemberVO member = memberDao.findId(email);
		String id = member.getMID();		
		sm.sendmailFindId(email, id);
		return member;
	}
	
	public int findPasswordCheck(String id, String email) {
		int result = memberDao.findPasswordCheck(id, email);
		return result;
	}
	
	public int updatePassword(String id, String email) {
		
		String code = Integer.toString((int) ((Math.random()*999999)+100000));
		
		sm.temporaryPassword(email, id, code);
		
		String temporaryPass = pwdEncoder.encode(code);
		int result = memberDao.updatePassword(id, email, temporaryPass);
		return result;
	}
}
