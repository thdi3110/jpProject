package MEMBER.service;


import org.springframework.stereotype.Service;

import MEMBER.dao.MemberDao;
import MEMBER.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;		
	
	public MemberDao getMemberDao() {
		return memberDao;
	}
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void writeNormal(MemberVO memberVO) {		
		memberDao.insertNormal(memberVO);
	}
	
	public void writeParcelOut(MemberVO memberVO) {
		memberDao.insertParcelOut(memberVO);
	}
	
	public void emailAuthentication(String M_EMAILCHECK) {
		memberDao.updateEmailAuthentication(M_EMAILCHECK);
	}
	
	public int idCheck(String M_ID) {
		int result = memberDao.idCheck(M_ID);
		return result;
	}
	
	public int regCheck(String M_REGISTRATION) {
		int result = memberDao.regCheck(M_REGISTRATION);
		return result;
	}
	
	public int emailChk(String M_EMAILCHECK) {
		int result = memberDao.emailChk(M_EMAILCHECK);
		return result;
	}
	
	public String loginCheck(String M_ID) {
		String oldPassword = (String) memberDao.loginCheck(M_ID);
		return oldPassword;
	}
	
	
}
