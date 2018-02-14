package com.playdata.util;

public class PageNavigation { //페이지에 표시되는 사이즈, 앞으로, 뒤로, 한페이지당 게시글 수 

	private String root;
	private boolean nowFirst; 
	private boolean nowEnd; 
	private int totalArticleCount; //총 게시물
	private int newArticleCount; // 2번째 페이지의 게시글 번호를 정함  (1번부터 or 11번 부터 ) 
	private int totalPageCount;   //총 페이지수  (게시글 100개, 페이지당 10개면   totalPageCount =10, 페이지당 20개면 totalPageCount=5) 
	private int pageNo; //페이지 넘버 (
	private String navigator; // 앞으로 or  뒤로 
	private int bcode;
	private String key;
	private String word;

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public boolean isNowFirst() {
		return nowFirst;
	}

	public void setNowFirst(boolean nowFirst) {
		this.nowFirst = nowFirst;
	}

	public boolean isNowEnd() {
		return nowEnd;
	}

	public void setNowEnd(boolean nowEnd) {
		this.nowEnd = nowEnd;
	}

	public int getTotalArticleCount() {
		return totalArticleCount;
	}

	public void setTotalArticleCount(int totalArticleCount) {
		this.totalArticleCount = totalArticleCount;
	}

	public int getNewArticleCount() {
		return newArticleCount;
	}

	public void setNewArticleCount(int newArticleCount) {
		this.newArticleCount = newArticleCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getBcode() {
		return bcode;
	}

	public void setBcode(int bcode) {
		this.bcode = bcode;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getNavigator() {
		return navigator;
	}

	public void setNavigator() {  //매개변수를 아무것도 안받고 //
		/* 최신목록   이전	

		 1	
		 다음 끝목록*/

		StringBuffer tmpNavigator = new StringBuffer();

		int pageSize = BoardConstance.PAGE_SIZE;
		
		tmpNavigator.append("<table cellpadding='0' cellspacing='0' border='0'>\n");   //테이블을 만들어서
		tmpNavigator.append(" <tr>\n");  //라인 한개 
		if (this.isNowFirst()) {
			tmpNavigator.append("  <td><font color='#999999'>\n<a href=\"javascript:listArticle('" + bcode + "', '1', '', '');\">"); //
			tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev02.gif' width='7' height='11' border='0' align='absmiddle' hspace='3'>최신목록</a>\n");
			tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev01_dim.gif' width='3' height='11' border='0' align='absmiddle' hspace='3'>\n");
			tmpNavigator.append("   이전</font>\n");
		} else {
			int prePage = (pageNo - 1) / pageSize * pageSize;
			tmpNavigator.append("  <td>\n<a href=\"javascript:listArticle('" + bcode + "', '1', '', '');\">");
			tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev02.gif' width='7' height='11' border='0' align='absmiddle' hspace='3'>최신목록 </a>\n");
			tmpNavigator.append("   <a href=\"javascript:listArticle('" + bcode + "', '" + prePage + "', '" + key + "', '" + word + "');\">");
			tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev01_dim.gif' width='3' height='11' border='0' align='absmiddle' hspace='3'>\n");
			tmpNavigator.append("   이전</a>");
		}
		tmpNavigator.append("  \n</td>\n");
		tmpNavigator.append("  <td style='padding: 0 5 0 5'>\n");
		tmpNavigator.append("   <table cellpadding='0' cellspacing='0' border='0'>\n");
		tmpNavigator.append("    <tr>\n");
		tmpNavigator.append("    아무거나글자 <td width='1' nowrap><img src='" + root + "/img/board/n_tab.gif' width='1'");
		tmpNavigator.append(" height='11' border='0' align='absmiddle'>아무거나글자2<br>"+pageSize+"/"+pageNo);  //pageSize= 10 pageNo=1 
		tmpNavigator.append("     </td>\n");
		
		int startPage = (pageNo - 1) / pageSize * pageSize + 1;   
		int endPage = startPage + pageSize - 1;   //(startPage=1)   + (pageSize=10) -1 
		if(endPage > totalPageCount)
			endPage = totalPageCount;
		
		for (int i = startPage; i <= endPage; i++) {  //페이지 번호를 표시함 
			if (pageNo == i) {  //현재 보여주는 페이지 번호가 i번지랑 같을 경우 
				tmpNavigator.append("     <td style='padding:0 7 0 7;' nowrap><font class='text_acc_02'><b>!!!!!" + i + "</b></font></td>\n");
				tmpNavigator.append("     <td width='1' nowrap><img src='" + root + "/img/board/n_tab.gif' width='1'");
				tmpNavigator.append(" height='11' border='0' align='absmiddle'><br>\n");
			} else {  //현재 보여주는 페이지 번호가 i번지랑 다를 경우 
				tmpNavigator.append("     <td style='padding:0 7 0 7;' nowrap><a href=\"javascript:listArticle('" + bcode + "', '" + i + "', '" + key + "', '" + word + "');\">" + i + "</td>\n");
				tmpNavigator.append("     <td width='1' nowrap><img src='" + root + "/img/board/n_tab.gif' width='1'");
				tmpNavigator.append(" height='11' border='0' align='absmiddle'><br>\n");  // 이미지 
			}
		}
		tmpNavigator.append("     </td>\n");
		tmpNavigator.append("    </tr>\n");
		tmpNavigator.append("   </table>\n");
		tmpNavigator.append("  </td>\n");
		tmpNavigator.append("  <td>\n");
		
		if (this.isNowEnd()) {  //마지막 페이지일 경우 
			tmpNavigator.append("   <font color='#999999'>다음<img");
			tmpNavigator.append("   src='" + root + "/img/board/icon_next01_dim.gif' width='3' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'> \n");
			tmpNavigator.append("   끝목록<img src='" + root + "/img/board/icon_next02_dim.gif' width='7' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'></font>\n");
		} else {
			int nextPage = (pageNo - 1) / pageSize * pageSize + pageSize + 1;//(pageNo + pageSize - 1) / pageSize * pageSize + 1
			tmpNavigator.append("   <a href=\"javascript:listArticle('" + bcode + "', '" + nextPage + "', '" + key + "', '" + word + "');\">다음<img");
			tmpNavigator.append(" src='" + root + "/img/board/icon_next01_dim.gif' width='3' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'></a>\n");
			tmpNavigator.append("   <a href=\"javascript:listArticle('" + bcode + "', '" + totalPageCount + "', '" + key + "', '" + word + "');\">끝목록<img src='" + root + "/img/board/icon_next02_dim.gif' width='7' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'>\n");
		}

		tmpNavigator.append("  </td>\n");
		tmpNavigator.append(" </tr>\n");
		tmpNavigator.append("</table>\n");

		this.navigator = tmpNavigator.toString();
	}

}

// <<최근목록<이전21 22 23 24 25 다음 >끝목록>>

















