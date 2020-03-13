package kr.co.spring;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.co.dao.MemberDAO;
import kr.co.vo.MemberVO;
@Service
public class AuthService {
	@Inject
	private MemberDAO memberDao;	
	@Inject
	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public AuthInfo authenticate(String id) {		
		MemberVO member = memberDao.selectById(id);		
		return new AuthInfo(member.getMID(), member.getMEMAIL(), member.getMDIVISION(), member.getMEMAILCHECK());
	}
}
