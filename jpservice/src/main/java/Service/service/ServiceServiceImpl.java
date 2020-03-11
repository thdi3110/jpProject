package Service.service;

import java.util.List;

import Service.dao.ServiceDao;
import Service.domain.ServiceVO;

public class ServiceServiceImpl implements ServiceService {
	
	private ServiceDao serviceDao;

	public ServiceDao getServiceDao() {
		return serviceDao;
	}

	public void setServiceDao(ServiceDao serviceDao) {
		this.serviceDao = serviceDao;
	}

	@Override
	public List<ServiceVO> list() {
		return serviceDao.list();
	}

	@Override
	public int delete(int SCNUM) {
		return serviceDao.delete(SCNUM);
	}

	@Override
	public int edit(ServiceVO serviceVO) {
		return serviceDao.update(serviceVO);
	}

	@Override
	public void write(ServiceVO serviceVO) {
		serviceDao.insert(serviceVO);
	}

	@Override
	public ServiceVO read(int SCNUM) {
		return serviceDao.select(SCNUM);
	}	
	

}
