package model;

import java.net.DatagramPacket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Order {
	
	private String id;
	private String type;
	private String product;

	
	private String time;
	
	public Order() {
		
	}
	
	public Order(String product) {
		
		this.product = product;
		
		id = UUID.randomUUID().toString();
		type = "Order";
		
		
	
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}

	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	

}
