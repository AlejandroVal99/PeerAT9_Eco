package model;

import java.net.DatagramPacket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Order {
	
	private String id;
	private String type;
	private String product;
	private DatagramPacket packet;
	private String ipport;
	private Date date;
	private SimpleDateFormat sdf;
	private String time;
	
	public Order() {
		
	}
	
	public Order(String product) {
		
		this.product = product;
		date = new Date();
		sdf =  new SimpleDateFormat("HH-mm:ss");
		time = sdf.format(date); 
		id = UUID.randomUUID().toString();
		type = "Order";
		ipport = packet.getSocketAddress().toString();
		
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
	public String getIpport() {
		return ipport;
	}
	public void setIpport(String ipport) {
		this.ipport = ipport;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	

}
