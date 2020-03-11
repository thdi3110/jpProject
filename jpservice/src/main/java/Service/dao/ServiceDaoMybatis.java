package Service.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import Service.domain.ServiceVO;

public class ServiceDaoMybatis implements ServiceDao {
	
	private SqlSessionTemplate sqlSessionTemplate;

	public ServiceDaoMybatis(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
    @Override
	public List<ServiceVO> list() {
		return sqlSessionTemplate.selectList("list");
	}
    
	@Override
	public int delete(int NCNUM) {
		return sqlSessionTemplate.delete("delete", NCNUM);
	}

	@Override
	public int update(ServiceVO servticeVO) {
		return sqlSessionTemplate.update("update", servticeVO);
	}

	@Override
	public void insert(ServiceVO servticeVO) {
		sqlSessionTemplate.insert("insert", servticeVO);
	}

	@Override
	public ServiceVO select(int NCNUM) {
		ServiceVO vo = (ServiceVO) sqlSessionTemplate.selectOne("select", NCNUM);
		return vo;
	}
	
	
	
}
