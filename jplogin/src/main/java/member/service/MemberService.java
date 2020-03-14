package member.service;

import member.domain.MemberVO;

public interface MemberService {
	
	public abstract void writeNormal(MemberVO memberVO, String password, String email, String phnum, String phone, String account);
	
	public abstract void writeParcelOut(MemberVO memberVO, String password, String email, String phnum, String phone, String account);
	
	public abstract void emailAuthentication(String MEMAILCHECK);
	
	public abstract int idCheck(String MID);
	
	public abstract int regCheck(String MREGISTRATION);
	
	public abstract int emailChk(String MEMAILCHECK);
	
	public abstract int findIdEmailCheck(String email);
	
	public abstract int updateEmailCode(String code, String email);
	
	public abstract int findPasswordCheck(String id, String email);
	
	public abstract int updatePassword(String id, String email);
	
	public abstract MemberVO findPassword(String id, String email);
	
	public abstract MemberVO findId(String email);
	
	public abstract String sendEmail(String MID);
	
	public abstract String loginCheck(String id, String matchPassword);
	
	
}
