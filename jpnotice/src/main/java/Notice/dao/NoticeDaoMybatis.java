package Notice.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import Notice.domain.NoticeVO;

public class NoticeDaoMybatis implements NoticeDao {
	
	private SqlSessionTemplate sqlSessionTemplate;

	public NoticeDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
    @Override
	public List<NoticeVO> list() {
		return sqlSessionTemplate.selectList("list");
	}
    
	@Override
	public int delete(int NBNUM) {
		return sqlSessionTemplate.delete("delete", NBNUM);
	}

	@Override
	public int update(NoticeVO noticeVO) {
		return sqlSessionTemplate.update("update", noticeVO);
	}

	@Override
	public void insert(NoticeVO noticeVO) {
		sqlSessionTemplate.insert("insert", noticeVO);
	}

	@Override
	public NoticeVO select(int NBNUM) {
		NoticeVO vo = (NoticeVO) sqlSessionTemplate.selectOne("select", NBNUM);
		return vo;
	}
	
	
	
}
