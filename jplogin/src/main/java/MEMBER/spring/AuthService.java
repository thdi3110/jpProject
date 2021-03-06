package MEMBER.spring;

import MEMBER.dao.MemberDao;
import MEMBER.domain.MemberVO;

public class AuthService {
	private MemberDao memberDao;	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public AuthInfo authenticate(String id) {		
		MemberVO member = memberDao.selectById(id);		
		return new AuthInfo(member.getMID(), member.getMEMAIL(), member.getMDIVISION(), member.getMEMAILCHECK());
	}
}
