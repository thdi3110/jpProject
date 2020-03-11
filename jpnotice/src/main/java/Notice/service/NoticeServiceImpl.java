package Notice.service;

import java.util.List;

import Notice.dao.NoticeDao;
import Notice.domain.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	
	private NoticeDao noticeDao;

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	@Override
	public List<NoticeVO> list() {
		return noticeDao.list();
	}

	@Override
	public int delete(int NBNUM) {
		return noticeDao.delete(NBNUM);
	}

	@Override
	public int edit(NoticeVO noticeVO) {
		return noticeDao.update(noticeVO);
	}

	@Override
	public void write(NoticeVO noticeVO) {
		noticeDao.insert(noticeVO);
	}

	@Override
	public NoticeVO read(int NBNUM) {
		return noticeDao.select(NBNUM);
	}	
	

}
