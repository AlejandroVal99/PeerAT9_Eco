package main;

import control.MainController;
import processing.core.PApplet;

public class Main extends PApplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("main.Main");
	}
	public  MainController controller;
	
	public void settings() {
		size(560,560);
	}
	public void setup() {
		controller = new MainController(this);
	}
	public void draw() {
		background(0,100,100);
		controller.pintarList();
	}
	public void mousePressed() {
		controller.orderCheck();
	}

}
