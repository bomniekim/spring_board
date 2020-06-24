package com.bomnie.test_board.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bomnie.test_board.service.BoardService;
import com.bomnie.test_board.vo.BoardVo;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Inject
	private BoardService boardService;

	@GetMapping(value = "/getBoardList")
	public String getBoardList(Model model) throws Exception {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/index";

	}

	// 글쓰기 화면
	@RequestMapping("/writeForm")
	public String boardWriteForm(@ModelAttribute("boardVo") BoardVo vo, Model model) {
		return "board/writeForm";
	}

	// 글쓰고 저장
	@PostMapping(value = "/saveBoard")
	public String saveBoard(@ModelAttribute("BoardVo") BoardVo vo, @RequestParam("mode") String mode,
			RedirectAttributes rttr) throws Exception {
		
		if(mode.equals("edit")) {			
			boardService.updateBoard(vo);
		} else {
			boardService.writeBoard(vo);
		}
		return "redirect:/board/getBoardList";
	}

	@GetMapping(value = "/getBoardDetail")
	public String getBoardDetail(Model model, @RequestParam("bid") int bid) throws Exception {
		model.addAttribute("boardContent", boardService.getBoardDetail(bid));
		// boardContent 라는 이름으로 묶어서 jsp로 데이터를 넘김
		return "board/boardContent";

	}

	@GetMapping(value = "/editForm")
	public String editForm(@RequestParam("bid") int bid, @RequestParam("mode") String mode, Model model)
			throws Exception {
		model.addAttribute("boardContent", boardService.getBoardDetail(bid));
		model.addAttribute("mode", mode);
		model.addAttribute("boardVo", new BoardVo());
		// 바로 아래 입력 폼의 수정을 위해 사용하게 되는데 입력폼과 연계 하기 위한 코드

		return "board/writeForm";

	}
	
	@GetMapping(value = "/deleteBoard")
	public String deleteBoard(RedirectAttributes rttr, @RequestParam("bid") int bid) throws Exception {
		boardService.deleteBoard(bid);
		return "redirect:/board/getBoardList";

	}

//	@ExceptionHandler(RuntimeException.class) // db에서 발생하는 에러 처리
//	public String exceptionHandler(Model model, Exception e){
//		model.addAttribute("exception", e);
//		return "error/exception";
//	}





	

}
