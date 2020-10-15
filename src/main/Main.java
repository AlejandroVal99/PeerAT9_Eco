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
		size(500,500);
	}
	public void setup() {
		controller = new MainController(this);
	}
	public void draw() {
		
	}

}
