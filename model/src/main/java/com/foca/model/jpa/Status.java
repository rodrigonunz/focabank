package com.foca.model.jpa;

public enum Status {
	
	CANCELLED(0, "CANCELLED"),
	CONFIRMED(1, "CONFIRMED"),
	NOTCONFIRMED(2, "NOTCONFIRMED");
	
	private final int id;
	private final String name;
	
	private Status(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

}
