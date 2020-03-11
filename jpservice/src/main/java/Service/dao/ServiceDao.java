package Service.dao;

import java.util.List;

import Service.domain.ServiceVO;

public interface ServiceDao {
		
	public abstract List<ServiceVO> list(); //Î™©Î°ù
	
	public abstract int delete(int SCNUM); // ?Ç≠?†ú
	
	public abstract int update(ServiceVO serviceVO); // ?àò?†ï
	
	public abstract void insert(ServiceVO serviceVO); //Í∏??ì∞Í∏?
	
	public abstract ServiceVO select(int SCNUM); // Í∏??Ç¥?ö©

}
