package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.app.util.Pager;
@Service
public class QnaService {
	@Autowired
	private QnaDAO qnaDAO;
	
	public List<QnaDTO> list (Pager pager)throws Exception{
		//1. totalCount 구하기
		Long totalCount= qnaDAO.count(pager);
		
		pager.pageing(totalCount);

		
		return qnaDAO.list(pager);
	}
	
	public QnaDTO detail(QnaDTO qnaDTO)throws Exception{
		return qnaDAO.detail(qnaDTO);
	}
	
	public int add(QnaDTO qnaDTO)throws Exception{
		return qnaDAO.add(qnaDTO);
	}
	
	public int update(QnaDTO qnaDTO)throws Exception{
		return qnaDAO.update(qnaDTO);
	}
	
	public int delete(QnaDTO qnaDTO)throws Exception{
		return qnaDAO.delete(qnaDTO);
	}
}
