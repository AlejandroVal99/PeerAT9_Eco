package comunnication;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPconnection extends Thread{

	private static UDPconnection instance;
	
	private UDPconnection () {
		
	}
	
	public static UDPconnection getInstance() {
		if (instance == null) {
			instance = new UDPconnection();
			instance.start();
		}
		return instance;
	}
	
	
	private DatagramSocket socket;
	
	public void run() {
		
		try {
			socket = new DatagramSocket(5000);
			
			 while(true) {
				 
				 byte[] buffer = new byte [100];
				 DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
				 socket.receive(packet);
				 
				 String msg = new String (packet.getData()).trim();
				 
				 System.out.println(msg);
				 
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
						
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				
				).start();
		
		
	}
	
	
	
}
