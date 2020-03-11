package MEMBER.dao;

import MEMBER.domain.MemberVO;

public interface MemberDao {
	
	 public abstract void insertNormal(MemberVO memberVO);
	 
	 public abstract void insertParcelOut(MemberVO memberVO);
	 
	 public abstract int updateEmailAuthentication(String MEMAILCHECK);
	 
	 public abstract int idCheck(String MID);
	 
	 public abstract int regCheck(String MREGISTRATION);	
	 
	 public abstract int emailChk(String MEMAILCHECK);
	 
	 public abstract MemberVO selectById(String MID);
	
	 public abstract MemberVO loginCheck(String MID);
}
