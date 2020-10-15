package control;

import java.util.ArrayList;

import com.google.gson.Gson;

import comunnication.UDPconnection;
import events.OnMessageListener;
import main.Main;
import model.Order;
import model.OrderStatus;
import model.inLimit;
import processing.core.PApplet;
import processing.core.PImage;
import view.OrderView;

public class MainController implements OnMessageListener{
	
	private PApplet app;
	private ArrayList<OrderView> orders;
	private UDPconnection udp;
	private PImage burger, hotDog, burrito, sandwich;
	private int orderMax;
	

	public MainController(PApplet app) {
		// TODO Auto-generated constructor stub
		this.app = app;
		orders = new ArrayList<OrderView>();
		udp = UDPconnection.getInstance();
		udp.setObserver(this);
		orderMax = 4;
		cargarRecursos();
	}

	
	
	

	public void pintarList(){
		
		for(int i = 0; i< orders.size();i++) {
			orders.get(i).pintar((i*140)+100);
		}
		
	}

	@Override
	public void OnOrderStatusReceived() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void OnOrderReceived(Order newOrder, String ip, int port) {
		
		if(orderMax<4) {
			orderMax++;
			switch(newOrder.getProduct()){
			
			case "Burger":
				orders.add(new OrderView(app,burger,newOrder.getTime(),ip,port));
				break;
			case "HotDog":
				orders.add(new OrderView(app,hotDog,newOrder.getTime(),ip,port));
				break;
			case "Burrito":
				orders.add(new OrderView(app,burrito,newOrder.getTime(),ip,port));
				break;
			case "Sandwich":
				orders.add(new OrderView(app,sandwich,newOrder.getTime(),ip,port));
				break;
				
			}
			inLimit limit = new inLimit(false);
			Gson gson = new Gson();
			String msg = gson.toJson(limit);
			udp.sendMessage(msg,ip,port);
		}else{
			inLimit limit = new inLimit(true);
			Gson gson = new Gson();
			String msg = gson.toJson(limit);
			udp.sendMessage(msg,ip,port);
			
		}
		
		
		
	}
	
	public void orderCheck() {
		for(int j = 0; j< orders.size();j++) {
			
			if(orders.get(j).touchMe()) {
				OrderStatus orderReady = new OrderStatus(true);
				Gson gson = new Gson();
				String msg = gson.toJson(orderReady);
				udp.sendMessage(msg,orders.get(j).getIp(),orders.get(j).getPort());
				orderMax--;
				orders.remove(j);
			}
			
		}
	}
	
	private void cargarRecursos() {
		burger = app.loadImage("../Resources/ProductImages/BurgerW.png");
		hotDog = app.loadImage("../Resources/ProductImages/HotDogW.png");
		burrito = app.loadImage("../Resources/ProductImages/BurritoW.png");
		sandwich = app.loadImage("../Resources/ProductImages/SandwichW.png");
		
	}

}
