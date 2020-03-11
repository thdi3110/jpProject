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
	
	public int updateEmailAuthentication(String MEMAILCHECK) {		
		return sqlSessionTemplate.update("memberDao.updateEmailAuthentication", MEMAILCHECK);
	}

	public MemberVO selectById(String MID) {		
		List<MemberVO> result = sqlSessionTemplate.selectList("memberDao.selectById", MID);
		return result.isEmpty()?null:result.get(0);
	}
	
	public int idCheck(String MID) {		
		int result = sqlSessionTemplate.selectOne("memberDao.idCheck", MID); 
		return result;
	}
	
	public int regCheck(String MREGISTRATION) {		
		int result = sqlSessionTemplate.selectOne("memberDao.regCheck",MREGISTRATION); 
		return result;
	}
	
	public int emailChk(String MEMAILCHECK) {		
		int result = sqlSessionTemplate.selectOne("memberDao.emailChk",MEMAILCHECK); 		
		return result;
	}
	
	public MemberVO loginCheck(String MID) {		
		List<MemberVO> result = sqlSessionTemplate.selectList("memberDao.loginCheck", MID);
		return result.isEmpty()?null:result.get(0);
	}
}
