package com.playdata.admin.board.model;

public class BoardTypeDto { //어떤 게시판인지 

	private int btype;
	private String btypeName;

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

	public String getBtypeName() {
		return btypeName;
	}

	public void setBtypeName(String btypeName) {
		this.btypeName = btypeName;
	}

}
