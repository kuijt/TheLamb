package com.lamb.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lamb.domain.BoardVO;
import com.lamb.service.BoardService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/board/")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Inject
	BoardService service;

	// 날짜 타입 데이터 변환
	@InitBinder
	protected void initBinder(WebDataBinder wdb) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		wdb.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {

		List<BoardVO> list = null;
		list = service.list();

		logger.info("list");
		model.addAttribute("list", list);

	}

	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write() throws Exception {

	}

	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String postWrite(BoardVO vo) throws Exception {

		service.write(vo);

		return "redirect:/board/list";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("bno") int bno, Model model) throws Exception {

		BoardVO view = null;
		view = service.view(bno);

		model.addAttribute("view", view);
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void getUpdate(@RequestParam("bno") int bno, Model model) throws Exception {

		BoardVO view = null;
		view = service.view(bno);

		model.addAttribute("view", view);

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO vo) throws Exception {

		service.update(vo);

		return "redirect:/board/list";

	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(@RequestParam("bno") int bno) throws Exception {

		service.delete(bno);

		return "redirect:/board/list";

	}

	@RequestMapping(value = "listPage", method = RequestMethod.GET)
	public void listPage(Model model, int num) throws Exception {

		// 게시물 총 개수
		int count = service.count();

		// 한페이지 출력 수
		int postNum = 5;
		// 전체 페이지 수
		int pageNum = (int) Math.ceil((double) count / (double) 5);

		//임시 페이지 번호
		//int selectNum = 1;

		int displayPost = (num - 1) * postNum;

		List<BoardVO> list = null;
		list = service.listPage(displayPost, postNum);
		
		model.addAttribute("list", list);
		model.addAttribute("pageNum", pageNum);

	}
}
