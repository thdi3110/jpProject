package Notice.dao;

import java.util.List;

import Notice.domain.NoticeVO;

public interface NoticeDao {
		
	public abstract List<NoticeVO> list(); //목록
	
	public abstract int delete(int NBNUM); // 삭제
	
	public abstract int update(NoticeVO noticeVO); // 수정
	
	public abstract void insert(NoticeVO noticeVO); //글쓰기
	
	public abstract NoticeVO select(int NBNUM); // 글내용

}
