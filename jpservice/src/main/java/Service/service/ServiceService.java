package Service.service;

import java.util.List;

import Service.domain.ServiceVO;

public interface ServiceService {
    
    public abstract List<ServiceVO> list(); //λͺ©λ‘
	
	public abstract int delete(int SCNUM); // ?­? 
	
	public abstract int edit(ServiceVO serviceVO); // ?? 
	
	public abstract void write(ServiceVO serviceVO); //κΈ??°κΈ?
	
	public abstract ServiceVO read(int SCNUM); //κΈ??΄?©

}
