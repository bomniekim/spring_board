package com.bomnie.test_board.vo;

public class BoardVo {
	
	private int bid; // 일련번호 
	private String cate_cd; // 게시글 카테고리 
	public String title; // 제목 
	private String content; // 내용
	private String tag; // 태그 
	private int view_cnt; // 조회수
	private String reg_id; // 글쓴이 
	private String reg_dt; // 작성일
	private String edit_dt; // 수정일
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getCate_cd() {
		return cate_cd;
	}
	public void setCate_cd(String cate_cd) {
		this.cate_cd = cate_cd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public int getView_cnt() {
		return view_cnt;
	}
	public void setView_cnt(int view_cnt) {
		this.view_cnt = view_cnt;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	public String getEdit_dt() {
		return edit_dt;
	}
	public void setEdit_dt(String edit_dt) {
		this.edit_dt = edit_dt;
	}
	
	@Override
	public String toString() {
		return "BoardVo [bid=" + bid + ", cate_cd=" + cate_cd + ", title=" + title + ", content=" + content + ", tag="
				+ tag + ", view_cnt=" + view_cnt + ", reg_id=" + reg_id + ", reg_dt=" + reg_dt + ", edit_dt=" + edit_dt
				+ "]";
	}
	
	
	
	



}
