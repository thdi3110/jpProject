package kr.co.dao;

import kr.co.vo.MemberVO;

public interface MemberDAO {
	public void insertNormal(MemberVO memberVO);

	public void insertParcelOut(MemberVO memberVO);

	public int updateEmailAuthentication(String MEMAILCHECK);

	public int idCheck(String MID);

	public int regCheck(String MREGISTRATION);

	public int emailChk(String MEMAILCHECK);

	public MemberVO selectById(String MID);

	public MemberVO loginCheck(String MID);
}
