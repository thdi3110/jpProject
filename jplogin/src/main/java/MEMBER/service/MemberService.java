package MEMBER.service;

import MEMBER.domain.MemberVO;

public interface MemberService {
	
	public abstract void writeNormal(MemberVO memberVO);
	
	public abstract void writeParcelOut(MemberVO memberVO);
	
	public abstract void emailAuthentication(String M_EMAILCHECK);
	
	public abstract int idCheck(String M_ID);
	
	public abstract int regCheck(String M_REGISTRATION);
	
	public abstract int emailChk(String M_EMAILCHECK);
	
	public abstract String loginCheck(String M_ID);
}
