package MEMBER.service;


import java.util.List;

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
	
	public MemberVO loginCheck(String MID) {
		MemberVO result = memberDao.loginCheck(MID);
		return result;
	}
	
	
}
