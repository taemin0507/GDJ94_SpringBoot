package com.winter.app.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeDAO {

	// 상세
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception;
	
	// 추가
	public int add(NoticeDTO noticeDTO)throws Exception;
	
	// 삭제
	public int delete(NoticeDTO noticeDTO) throws Exception;
	
	// 업데이트
	public int update(Map<String, Object> map) throws Exception;
	
	// 리스트
	public List<NoticeDTO> list()throws Exception;
}
