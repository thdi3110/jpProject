package MEMBER.spring;

import MEMBER.dao.MemberDao;
import MEMBER.domain.MemberVO;

public class AuthService {
	private MemberDao memberDao;	
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public AuthInfo authenticate(String id) {
		System.out.println(id);
		MemberVO member = memberDao.selectById(id);
		System.out.println(member);
		System.out.println(member.getM_ID());
		
		return new AuthInfo(member.getM_ID(), member.getM_EMAIL(), member.getM_DIVISION(), member.getM_EMAILCHECK());
	}
}
