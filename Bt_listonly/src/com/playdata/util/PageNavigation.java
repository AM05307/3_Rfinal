package com.playdata.util;

public class PageNavigation { //�������� ǥ�õǴ� ������, ������, �ڷ�, ���������� �Խñ� �� 

	private String root;
	private boolean nowFirst; 
	private boolean nowEnd; 
	private int totalArticleCount; //�� �Խù�
	private int newArticleCount; // 2��° �������� �Խñ� ��ȣ�� ����  (1������ or 11�� ���� ) 
	private int totalPageCount;   //�� ��������  (�Խñ� 100��, �������� 10����   totalPageCount =10, �������� 20���� totalPageCount=5) 
	private int pageNo; //������ �ѹ� (
	private String navigator; // ������ or  �ڷ� 
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

	public void setNavigator() {  //�Ű������� �ƹ��͵� �ȹް� //
		/* �ֽŸ��   ����	

		 1	
		 ���� �����*/

		StringBuffer tmpNavigator = new StringBuffer();

		int pageSize = BoardConstance.PAGE_SIZE;
		
		tmpNavigator.append("<table cellpadding='0' cellspacing='0' border='0'>\n");   //���̺��� ����
		tmpNavigator.append(" <tr>\n");  //���� �Ѱ� 
		if (this.isNowFirst()) {
			tmpNavigator.append("  <td><font color='#999999'>\n<a href=\"javascript:listArticle('" + bcode + "', '1', '', '');\">"); //
			tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev02.gif' width='7' height='11' border='0' align='absmiddle' hspace='3'>�ֽŸ��</a>\n");
			tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev01_dim.gif' width='3' height='11' border='0' align='absmiddle' hspace='3'>\n");
			tmpNavigator.append("   ����</font>\n");
		} else {
			int prePage = (pageNo - 1) / pageSize * pageSize;
			tmpNavigator.append("  <td>\n<a href=\"javascript:listArticle('" + bcode + "', '1', '', '');\">");
			tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev02.gif' width='7' height='11' border='0' align='absmiddle' hspace='3'>�ֽŸ�� </a>\n");
			tmpNavigator.append("   <a href=\"javascript:listArticle('" + bcode + "', '" + prePage + "', '" + key + "', '" + word + "');\">");
			tmpNavigator.append("   <img src='" + root + "/img/board/icon_prev01_dim.gif' width='3' height='11' border='0' align='absmiddle' hspace='3'>\n");
			tmpNavigator.append("   ����</a>");
		}
		tmpNavigator.append("  \n</td>\n");
		tmpNavigator.append("  <td style='padding: 0 5 0 5'>\n");
		tmpNavigator.append("   <table cellpadding='0' cellspacing='0' border='0'>\n");
		tmpNavigator.append("    <tr>\n");
		tmpNavigator.append("    �ƹ��ų����� <td width='1' nowrap><img src='" + root + "/img/board/n_tab.gif' width='1'");
		tmpNavigator.append(" height='11' border='0' align='absmiddle'>�ƹ��ų�����2<br>"+pageSize+"/"+pageNo);  //pageSize= 10 pageNo=1 
		tmpNavigator.append("     </td>\n");
		
		int startPage = (pageNo - 1) / pageSize * pageSize + 1;   
		int endPage = startPage + pageSize - 1;   //(startPage=1)   + (pageSize=10) -1 
		if(endPage > totalPageCount)
			endPage = totalPageCount;
		
		for (int i = startPage; i <= endPage; i++) {  //������ ��ȣ�� ǥ���� 
			if (pageNo == i) {  //���� �����ִ� ������ ��ȣ�� i������ ���� ��� 
				tmpNavigator.append("     <td style='padding:0 7 0 7;' nowrap><font class='text_acc_02'><b>!!!!!" + i + "</b></font></td>\n");
				tmpNavigator.append("     <td width='1' nowrap><img src='" + root + "/img/board/n_tab.gif' width='1'");
				tmpNavigator.append(" height='11' border='0' align='absmiddle'><br>\n");
			} else {  //���� �����ִ� ������ ��ȣ�� i������ �ٸ� ��� 
				tmpNavigator.append("     <td style='padding:0 7 0 7;' nowrap><a href=\"javascript:listArticle('" + bcode + "', '" + i + "', '" + key + "', '" + word + "');\">" + i + "</td>\n");
				tmpNavigator.append("     <td width='1' nowrap><img src='" + root + "/img/board/n_tab.gif' width='1'");
				tmpNavigator.append(" height='11' border='0' align='absmiddle'><br>\n");  // �̹��� 
			}
		}
		tmpNavigator.append("     </td>\n");
		tmpNavigator.append("    </tr>\n");
		tmpNavigator.append("   </table>\n");
		tmpNavigator.append("  </td>\n");
		tmpNavigator.append("  <td>\n");
		
		if (this.isNowEnd()) {  //������ �������� ��� 
			tmpNavigator.append("   <font color='#999999'>����<img");
			tmpNavigator.append("   src='" + root + "/img/board/icon_next01_dim.gif' width='3' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'> \n");
			tmpNavigator.append("   �����<img src='" + root + "/img/board/icon_next02_dim.gif' width='7' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'></font>\n");
		} else {
			int nextPage = (pageNo - 1) / pageSize * pageSize + pageSize + 1;//(pageNo + pageSize - 1) / pageSize * pageSize + 1
			tmpNavigator.append("   <a href=\"javascript:listArticle('" + bcode + "', '" + nextPage + "', '" + key + "', '" + word + "');\">����<img");
			tmpNavigator.append(" src='" + root + "/img/board/icon_next01_dim.gif' width='3' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'></a>\n");
			tmpNavigator.append("   <a href=\"javascript:listArticle('" + bcode + "', '" + totalPageCount + "', '" + key + "', '" + word + "');\">�����<img src='" + root + "/img/board/icon_next02_dim.gif' width='7' height='11'");
			tmpNavigator.append(" border='0' align='absmiddle' hspace='3'>\n");
		}

		tmpNavigator.append("  </td>\n");
		tmpNavigator.append(" </tr>\n");
		tmpNavigator.append("</table>\n");

		this.navigator = tmpNavigator.toString();
	}

}

// <<�ֱٸ��<����21 22 23 24 25 ���� >�����>>

















