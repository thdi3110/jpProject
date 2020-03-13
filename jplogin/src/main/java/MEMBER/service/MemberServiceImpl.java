package member.service;


import java.util.List;

import org.springframework.stereotype.Service;

import member.dao.MemberDao;
import member.domain.MemberVO;

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
	
	public MemberVO sendEmail(String MID) {
		System.out.println(MID);
		MemberVO result = memberDao.sendEmail(MID);
		return result;
	}
	
	public MemberVO loginCheck(String MID) {
		MemberVO result = memberDao.loginCheck(MID);
		return result;
	}
	
	public MemberVO findPassword(String id, String email) {
		MemberVO result = memberDao.findPassword(id, email);
		return result;
	}
	
	
	public int updateEmailCode(String code , String email) {
		int result = memberDao.updateEmailCode(code, email);
		return result;
	}
	
	public int findIdEmailCheck(String email) {
		int result = memberDao.findIdEmailCheck(email);
		return result;
	}
	
	public MemberVO findId(String email) {
		MemberVO result = memberDao.findId(email);
		return result;
	}
	
	public int findPasswordCheck(String id, String email) {
		int result = memberDao.findPasswordCheck(id, email);
		return result;
	}
	
	public int updatePassword(String id, String email, String temporaryPass) {
		int result = memberDao.updatePassword(id, email, temporaryPass);
		return result;
	}
}
