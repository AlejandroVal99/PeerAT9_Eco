package view;

import processing.core.PApplet;
import processing.core.PImage;

public class OrderView {
	private PImage image;
	private String ip;
	private int port;
	private PApplet app;
	private String time;
	private int posy;
	
	public OrderView(PApplet app, PImage image,String time, String ip, int port) {
		this.image = image;
		this.app = app;
		this.ip = ip;
		this.port = port;
		this.time = time;
		
	}
	
	public void pintar(int posy) {
		
		this.posy = posy;
		
		app.image(image,30,this.posy);
		app.fill(0);
		app.text(time,215,this.posy+80);
		
	}
	
	public boolean touchMe() {
		
		if( app.mouseX > 375 && app.mouseX < 515 && app.mouseY > posy+9 && app.mouseY < posy+101){
			
			return true;
			
		}
		return false;
		
	}

	public PImage getImage() {
		return image;
	}

	public void setImage(PImage image) {
		this.image = image;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	

}
