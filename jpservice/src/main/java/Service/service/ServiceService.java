package Service.service;

import java.util.List;

import Service.domain.ServiceVO;

public interface ServiceService {
    
    public abstract List<ServiceVO> list(); //Î™©Î°ù
	
	public abstract int delete(int SCNUM); // ?Ç≠?†ú
	
	public abstract int edit(ServiceVO serviceVO); // ?àò?†ï
	
	public abstract void write(ServiceVO serviceVO); //Í∏??ì∞Í∏?
	
	public abstract ServiceVO read(int SCNUM); //Í∏??Ç¥?ö©

}
