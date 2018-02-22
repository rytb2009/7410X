package com.raysworks.game.entity;

public enum BlankGridMoveDirection {
	UP("N"), 
	DOWN("S"), 
	LEFT("W"), 
	RIGHT("E"), 
	NONE("");
	
	private String code;
	
	private BlankGridMoveDirection(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return this.code;
	}
}
