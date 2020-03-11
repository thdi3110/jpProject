package MEMBER.service;

import MEMBER.domain.MemberVO;

public interface MemberService {
	
	public abstract void writeNormal(MemberVO memberVO);
	
	public abstract void writeParcelOut(MemberVO memberVO);
	
	public abstract void emailAuthentication(String MEMAILCHECK);
	
	public abstract int idCheck(String MID);
	
	public abstract int regCheck(String MREGISTRATION);
	
	public abstract int emailChk(String MEMAILCHECK);
	
	public abstract MemberVO loginCheck(String MID);
}
