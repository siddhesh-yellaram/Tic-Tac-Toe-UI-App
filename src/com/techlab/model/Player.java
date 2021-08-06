package com.techlab.model;

public class Player {
	private String pName;
	private Mark pMark;

	public Player(String pName, Mark pMark) {
		this.pName = pName;
		this.pMark = pMark;
	}

	public String getpName() {
		return pName;
	}

	public Mark getpMark() {
		return pMark;
	}

}
