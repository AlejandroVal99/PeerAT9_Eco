package comunnication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.Gson;

import events.OnMessageListener;
import model.Generic;
import model.Order;

public class UDPconnection extends Thread{

	private static UDPconnection instance;
	private OnMessageListener observer;
	
	private UDPconnection () {
		
	}
	
	public static UDPconnection getInstance() {
		if (instance == null) {
			instance = new UDPconnection();
			instance.start();
		}
		return instance;
	}
	public void setObserver(OnMessageListener observer) {
		
		this.observer = observer;
		
	}
	
	private DatagramSocket socket;
	
	public void run() {
		
		try {
			socket = new DatagramSocket(5000);
			
			 while(true) {
				 
				 byte[] buffer = new byte [250];
				 DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
				 socket.receive(packet);
				 
				 String ipPort = packet.getSocketAddress().toString();
			
				 String netInfo[]=ipPort.split(":");
				 String ip = netInfo[0];
				 ip = ip.replace("/", "");
				 
				 int port = Integer.parseInt(netInfo[1]);
				 System.out.println(ip + " "+port);
				 String msg = new String (packet.getData()).trim();
				 System.out.println(msg);
				 
				 Gson gson = new Gson();
				 
				 Generic generic = gson.fromJson(msg,Generic.class);
				 
				 switch(generic.getType()) {
				 
				 case "Order":
					 Order newOrder = gson.fromJson(msg,Order.class);
					  Date date = new Date();
				      SimpleDateFormat sdf =  new SimpleDateFormat("HH:mm:ss");
				       String time = sdf.format(date);
					 newOrder.setTime(time);
					 observer.OnOrderReceived(newOrder,ip,port);
					 
					 break;
				 
				 }
				 
				 
				 
				 System.out.println(msg + ipPort);
				 
			 }
			 
			 
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendMessage(String msg, String direction, int port) {
		
		new Thread(
				()->{
					
					try {
						
						InetAddress ip = InetAddress.getByName(direction);
						DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length,ip,port);
						socket.send(packet);
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
				).start();
		
		
	}
	
	
	
}
