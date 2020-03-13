package kr.co.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.MemberVO;


@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertNormal(MemberVO memberVO) {		
		sqlSession.insert("memberMapper.insertNormal", memberVO);
	}

	@Override
	public void insertParcelOut(MemberVO memberVO) {		
		sqlSession.insert("memberMapper.insertParcelOut", memberVO);
	}	
	
	@Override
	public int updateEmailAuthentication(String MEMAILCHECK) {		
		return sqlSession.update("memberMapper.updateEmailAuthentication", MEMAILCHECK);
	}
	
	@Override
	public MemberVO selectById(String MID) {		
		List<MemberVO> result = sqlSession.selectList("memberMapper.selectById", MID);
		return result.isEmpty()?null:result.get(0);
	}
	
	@Override
	public int idCheck(String MID) {		
		int result = sqlSession.selectOne("memberMapper.idCheck", MID); 
		return result;
	}
	
	@Override
	public int regCheck(String MREGISTRATION) {		
		int result = sqlSession.selectOne("memberMapper.regCheck",MREGISTRATION); 
		return result;
	}
	
	@Override
	public int emailChk(String MEMAILCHECK) {		
		int result = sqlSession.selectOne("memberMapper.emailChk",MEMAILCHECK); 		
		return result;
	}
	
	@Override
	public MemberVO loginCheck(String MID) {		
		List<MemberVO> result = sqlSession.selectList("memberMapper.loginCheck", MID);
		return result.isEmpty()?null:result.get(0);
	}
}

	
	
	

