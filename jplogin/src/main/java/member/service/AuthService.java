package member.service;

import member.dao.MemberDao;
import member.domain.AuthInfo;
import member.domain.MemberVO;

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
