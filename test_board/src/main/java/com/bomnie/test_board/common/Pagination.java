package com.bomnie.test_board.common;

public class Pagination {

	private int listSize = 10;  // 한 페이지 당 보여질 리스트 개수 (세로)
	private int rangeSize = 10; // 한 페이지 범위에 보여질 페이지의 개수 (가로) 
	private int page; // 현재 페이지 번호 
	private int range; // 현재 페이지가 총 페이지 범위의 몇번째인가 (페이지 범위 단위)
	private int totalListCnt; // 전체 게시물의 수 
	private int pageCnt; // 전체 페이지 개수 (가로) 
	private int startPage; // 각 페이지 범위 시작 번호 
	private int endPage; // 각 페이지 범위 끝 번호 
	private int startList; // 게시판 시작 번호
	private boolean prev;  // 이전 페이지 여부
	private boolean next; // 다음 페이지 여부 
	
	
	public void pageInfo(int page, int range, int totalListCnt) {
		this.page = page;
		this.range = range;
		this.totalListCnt = totalListCnt;


		//전체 페이지수 == 전체 리스트 개수 / 한 페이지 당 보여질 리스트 개수
		this.pageCnt = (int) Math.ceil(totalListCnt/listSize);

		
		//각 페이지 범위 시작 번호 == ( 페이지 범위 단위  - 1) * 한 페이지 범위에 보여질 페이지의 개수 + 1
		// 1, 11, 21 ...
		this.startPage = (range - 1) * rangeSize + 1 ;
		

		//끝 페이지
		// 10, 20, 30 ...
		this.endPage = range * rangeSize;

				
		//게시판 시작번호
		// 게시판의 시작번호를 따로 구하는 이유는 현재 MySQL을 이용해 원하는 목록을 가져 오기 위해서
		this.startList = (page - 1) * listSize;


		//이전 버튼 상태
		// 첫번째 페이지 범위에서는 [이전] 불필요 : false
		this.prev = range == 1 ? false : true;


		//다음 버튼 상태
		this.next = endPage > pageCnt ? false : true;
		// 마지막 번호와 페이지의 총 개수를 비교하여 마지막 번호가 총 개수보다 크다면 마지막 번호로 세팅 되도록
		if (this.endPage > this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false; // [다음] 비활성화

		}

	}
	
	public int getListSize() {
		return listSize;
	}
	
	public void setListSize(int listSize) {
		this.listSize = listSize;
	}
	
	public int getRangeSize() {
		return rangeSize;
	}
	
	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getRange() {
		return range;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	
	public int gettotalListCnt() {
		return totalListCnt;
	}
	
	public void settotalListCnt(int totalListCnt) {
		this.totalListCnt = totalListCnt;
	}
	
	public int getPageCnt() {
		return pageCnt;
	}
	
	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getStartList() {
		return startList;
	}
	public void setStartList(int startList) {
		this.startList = startList;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public boolean isPrev() {
		return prev;
	}
	
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	
	public boolean isNext() {
		return next;
	}
	
	public void setNext(boolean next) {
		this.next = next;
	}

}



