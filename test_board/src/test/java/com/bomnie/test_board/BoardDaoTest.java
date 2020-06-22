package com.bomnie.test_board;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bomnie.test_board.dao.BoardDao;
import com.bomnie.test_board.vo.BoardVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/root-context.xml",
		"classpath:spring/dataSource-context.xml"
		})
public class BoardDaoTest {
private static final Logger logger = LoggerFactory.getLogger(BoardDaoTest.class);

	
	@Inject
	private BoardDao dao;

	@Test @Ignore
	public void testGetBoardList() throws Exception {

		List<BoardVo> boardList = dao.getBoardList();

		logger.info("\n Board List \n ");
		if(boardList.size() > 0) {
			for(BoardVo list : boardList) {
				logger.info(list.title);
			}
		} else {
			logger.info("데이터가 없습니다.");
		}

	}

	

	@Test @Ignore
	public void testGetBoardDetail() throws Exception {
		BoardVo vo = dao.getBoardDetail(1);
		logger.info("\n Board List \n ");

		if(vo != null) {

			logger.info("글번호 : " + vo.getBid() );
			logger.info("글제목 : " + vo.getTitle() );
			logger.info("글내용 : " + vo.getContent() );
			logger.info("글태그 : " + vo.getTag() );
			logger.info("조회수 : " + vo.getView_cnt() );
			logger.info("작성자 : " + vo.getReg_id() );
			logger.info("작성일 : " + vo.getReg_dt() );
			logger.info("수정일 : " + vo.getEdit_dt() );
		} else {
			logger.info("데이터가 없습니다.");

		}

	}

	

	@Test 
	public void testInsertBoard() throws Exception {
		BoardVo vo = new BoardVo();
		
		vo.setCate_cd("1");
		vo.setTitle("첫번째 게시물 입니다.");
		vo.setContent("첫번째 게시물입니다.");
		vo.setTag("1");
		vo.setReg_id("1");

		int result = dao.writeBoard(vo);

		logger.info("\n Write Board Result " +result);

		if(result == 1) {
			logger.info("\n 게시물 등록 성공 ");
		} else {
			logger.info("\n 게시물 등록 실패");

		}
	}

	
	@Test @Ignore 
	public void testUpdateBoard() throws Exception {

		BoardVo vo = new BoardVo();

		vo.setBid(1);
		vo.setCate_cd("1");
		vo.setTitle("첫번째 게시물 입니다-수정 합니다.");
		vo.setContent("첫번째 게시물입니다-수정합니다.");
		vo.setTag("1-1");

		int result = dao.updateBoard(vo);

		logger.info("\n Update Board Result \n ");
		if(result > 0) {
			logger.info("\n 게시물 수정 성공 ");
		} else {
			logger.info("\n 게시물 수정 실패");
		}
	}

	

	@Test @Ignore

	public void tesDeleteBoard() throws Exception {

		int result = dao.deleteBoard(1);
		logger.info("\n Delete Board Result \n ");
		if(result > 0) {
			logger.info("\n 게시물 삭제 성공 ");
		} else {
			logger.info("\n 게시물 삭제 실패");

		}
	}


	@Test @Ignore

	public void testUpdateViewCnt() throws Exception {

		int result = dao.updateViewCnt(1);

		logger.info("\n Update View Count Result \n ");
		if(result > 0) {
			logger.info("\n 게시물 조회수 업데이트 성공 ");
		} else {
			logger.info("\n 게시물 조회수 업데이트 실패");

		}

	}

}



