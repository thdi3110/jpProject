package Service.dao;

import java.util.List;

import Service.domain.ServiceVO;

public interface ServiceDao {
		
	public abstract List<ServiceVO> list(); //λͺ©λ‘
	
	public abstract int delete(int SCNUM); // ?­? 
	
	public abstract int update(ServiceVO serviceVO); // ?? 
	
	public abstract void insert(ServiceVO serviceVO); //κΈ??°κΈ?
	
	public abstract ServiceVO select(int SCNUM); // κΈ??΄?©

}
