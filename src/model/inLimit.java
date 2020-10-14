package model;

import java.util.UUID;

public class inLimit {
	
	String type,id,msg;
	
	
	public inLimit() {
		
	}
	
	public inLimit(String msg) {
		this.msg = msg;
		id = UUID.randomUUID().toString();
		type = "inLimit";
	}
	
	
}
