package com.yuni.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuni.model.BoardVO;
import com.yuni.model.Criteria;
import com.yuni.model.PageMaker;
import com.yuni.service.BoardServiceImpl;

import lombok.extern.log4j.Log4j;

@RequestMapping("/board/*")
@Controller
@Log4j
public class BoardController {

	@Inject
	private BoardServiceImpl service;

	@RequestMapping("list")
	public String list(Model model) throws Exception {
		model.addAttribute("list", service.listAll());
		return "/board/list";
	}
	
	@GetMapping("get")
	public String get(@RequestParam("bno")int bno , Model model) throws Exception {
		
		model.addAttribute("board", service.read(bno));
		return "/board/get";
	}
	
	@GetMapping("modify")
	public String modifyGet (@RequestParam("bno")int bno , Model model) throws Exception {
		model.addAttribute("board", service.read(bno));
		return "/board/modify";
		
	}
	@PostMapping("modifypost")
	public String modifyPost(BoardVO board) throws Exception {
		service.modify(board);
		log.info(board.getTitle());
		return	"redirect:/board/list";
		
	}
	
	@PostMapping("remove")
	public String remove (@RequestParam("bno")int bno) throws Exception {
		service.remove(bno);
		
		return "redirect:/board/list";
		
	}
	
	@GetMapping("listPage")
	public void listPage(Criteria cri, Model model, @RequestParam("page")int page) throws Exception {
		System.out.println(page);
		cri.setPage(page);
		cri.setPageStart(1);
	
		System.out.println(" ....................."+cri.getPage());
		System.out.println(" ....................."+cri.getPageStart());
		
		model.addAttribute("list", service.listCriteria(cri));
		
		PageMaker pageMaker= new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listAll().size());
		System.out.println(" ....................."+pageMaker.getStartPage());
		System.out.println(" ....................."+pageMaker.getEndPage());
		System.out.println(" ....................."+pageMaker.getTotalCount());
		
		model.addAttribute("pageMaker",pageMaker);
		
		
	}

}
