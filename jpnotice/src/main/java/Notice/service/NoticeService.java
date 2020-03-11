package Notice.service;

import java.util.List;

import Notice.domain.NoticeVO;

public interface NoticeService {
    
    public abstract List<NoticeVO> list(); //목록
	
	public abstract int delete(int NBNUM); // 삭제
	
	public abstract int edit(NoticeVO noticeVO); // 수정
	
	public abstract void write(NoticeVO noticeVO); //글쓰기
	
	public abstract NoticeVO read(int NBNUM); //글내용

}
