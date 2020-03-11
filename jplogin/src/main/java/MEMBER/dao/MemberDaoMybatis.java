package MEMBER.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import MEMBER.domain.MemberVO;

@Repository
public class MemberDaoMybatis implements MemberDao{

	private SqlSessionTemplate sqlSessionTemplate;
	
	public MemberDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	@Override
	public void insertNormal(MemberVO memberVO) {		
		sqlSessionTemplate.insert("memberDao.insertNormal", memberVO);
	}

	@Override
	public void insertParcelOut(MemberVO memberVO) {		
		sqlSessionTemplate.insert("memberDao.insertParcelOut", memberVO);
	}	
	
	public int updateEmailAuthentication(String M_EMAILCHECK) {		
		return sqlSessionTemplate.update("memberDao.updateEmailAuthentication", M_EMAILCHECK);
	}

	public MemberVO selectById(String M_ID) {		
		List<MemberVO> result = sqlSessionTemplate.selectList("memberDao.selectById", M_ID);
		return result.get(0);
	}
	
	public int idCheck(String M_ID) {		
		int result = sqlSessionTemplate.selectOne("memberDao.idCheck", M_ID); 
		return result;
	}
	
	public int regCheck(String M_REGISTRATION) {		
		int result = sqlSessionTemplate.selectOne("memberDao.regCheck",M_REGISTRATION); 
		return result;
	}
	
	public int emailChk(String M_EMAILCHECK) {		
		int result = sqlSessionTemplate.selectOne("memberDao.emailChk",M_EMAILCHECK); 
		return result;
	}
	
	public String loginCheck(String M_ID) {		
		String oldPassword = sqlSessionTemplate.selectOne("memberDao.loginCheck", M_ID);
		return oldPassword;
	}
}
