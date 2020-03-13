package kr.co.service;

import kr.co.vo.MemberVO;

public interface MemberService {

	public abstract void writeNormal(MemberVO memberVO);

	public void writeParcelOut(MemberVO memberVO);

	public void emailAuthentication(String MEMAILCHECK);

	public int idCheck(String MID);

	public int regCheck(String MREGISTRATION);

	public int emailChk(String MEMAILCHECK);

	public MemberVO loginCheck(String MID);
}
