package events;

import model.Order;

public interface OnMessageListener {
	
	void OnOrderReceived(Order newOrder, String ip, int port);
	void OnOrderStatusReceived();
	void OnLimitReceived();
	

}
