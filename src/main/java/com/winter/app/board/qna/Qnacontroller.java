package com.winter.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.winter.app.board.notice.NoticeController;
import com.winter.app.board.notice.NoticeDTO;
import com.winter.app.board.notice.NoticeService;
import com.winter.app.util.Pager;

import lombok.extern.slf4j.Slf4j;
@Controller
@RequestMapping("/qna/*")
@Slf4j
public class Qnacontroller {
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public void list(Pager pager, Model model)throws Exception{
		

		List<QnaDTO> list= qnaService.list(pager);
	
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
	}
	
	@GetMapping("detail")
	public void detail(QnaDTO qnaDTO, Model model)throws Exception{
		qnaDTO = qnaService.detail(qnaDTO);
		
		//null(조회실패시 처리)
		
		model.addAttribute("dto", qnaDTO);
		
	}
	
	@GetMapping("add")
	public void add()throws Exception{}
	
	@PostMapping("add")
	public String add(QnaDTO qnaDTO)throws Exception{
		int result = qnaService.add(qnaDTO);
		
		return "redirect:./list";
		
	}

}
