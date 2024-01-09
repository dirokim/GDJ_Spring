package com.winter.app.util;

import com.winter.app.regions.RegionDAO;

public class Pager {

	
	private Long startRow;
	private Long lastRow;
	private Long perPage=10L;//몇개씩 볼거냐
	//startRow 랑 lastRow 계싼하는 메서드
	private Long page;
	private Long totalPage;
    private	Long startNum ;
    private	Long lastNum  ;
	private boolean start;
	private boolean last;
    
	//검색 관련 
	private String search;
	private String kind;
	
    //이전 블럭이 없으면 true ;
	//다음 블럭이 없으면 true;
	
	
    
    
	public Long getStartNum() {
		return startNum;
	}
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public boolean isLast() {
		return last;
	}
	public void setLast(boolean last) {
		this.last = last;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public void makeRow() {
		this.startRow = ((this.getPage()-1)*this.getPerPage())+1;
		this.lastRow =  this.getPage()*this.getPerPage();
	

	
	}
	public void makeNum(Long totalCount) throws Exception {

	
		Long totalPage = 0L;
		totalPage= totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}
		// 총블럭의수 구하기
		Long perBlock = 5L; //블럭당 번호의 개수
		Long totalBlock= 0L;
		
		totalBlock=totalPage/perBlock;
		if(totalPage%perBlock != 0) {
			totalBlock++;
		}
		
		//3.파라미터로 온 페이지 값으로 현재 블럭번호 찾기
		Long curBlock= 0L;//현재의 블럭번호
		curBlock = this.getPage()/perBlock;
		if(this.getPage()%perBlock!=0) {
			curBlock++;
		}
		//4.현재 블럭번호로 시작번호와 끝번호를 구하기 
		Long startNum =0L;
		Long lastNum = 0L;
		lastNum= curBlock * perBlock;
		startNum = lastNum-perBlock+1;
		this.setStartNum(startNum);
		this.setLastNum(lastNum);
		
		//이전 , 다음 블럭 유무
		if(curBlock==1) {
			this.setStart(true);
		}
		if(curBlock==totalBlock) {
			this.setLastNum(totalPage);
			this.setLast(true);
		}
	}
	public Long getPerPage() {
		return perPage;
	}


	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}


	public Long getPage() {
		if(this.page==null||this.page<1) {
			this.page=1L;
		}
		return page;
	}


	public void setPage(Long page) {
		this.page = page;
	}


	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	public Long getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
	
	
}
