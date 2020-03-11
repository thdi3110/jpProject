package MEMBER.dao;

import MEMBER.domain.MemberVO;

public interface MemberDao {
	
	 public abstract void insertNormal(MemberVO memberVO);
	 
	 public abstract void insertParcelOut(MemberVO memberVO);
	 
	 public abstract int updateEmailAuthentication(String M_EMAILCHECK);
	 
	 public abstract int idCheck(String M_ID);
	 
	 public abstract int regCheck(String M_REGISTRATION);	
	 
	 public abstract int emailChk(String M_EMAILCHECK);
	 
	 public abstract MemberVO selectById(String M_ID);
	
	 public abstract String loginCheck(String M_ID);
}
