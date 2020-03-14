package member.dao;

import member.domain.MemberVO;

public interface MemberDao {
	
	 public abstract void insertNormal(MemberVO memberVO);
	 
	 public abstract void insertParcelOut(MemberVO memberVO);
	 
	 public abstract int updateEmailAuthentication(String MEMAILCHECK);
	 
	 public abstract int idCheck(String MID);
	 
	 public abstract int regCheck(String MREGISTRATION);	
	 
	 public abstract int emailChk(String MEMAILCHECK);
	 
	 public abstract int findIdEmailCheck(String email);
	 
	 public abstract int findPasswordCheck(String id, String email);
	 
	 public abstract int updatePassword(String id, String email, String temporaryPass);
	 
	 public abstract MemberVO findPassword(String id, String email);
	 
	 public abstract MemberVO sendEmail(String MID);
	 
	 public abstract MemberVO selectById(String MID);
	
	 public abstract MemberVO loginCheck(String MID);

	 public abstract int updateEmailCode(String code, String email);
	 
	 public abstract MemberVO findId(String email);
}
