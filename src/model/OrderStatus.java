
package model;

import java.util.UUID;

public class OrderStatus {
	
	private boolean ready;
	private String id, type;
	public OrderStatus() {
		
	}

	public OrderStatus(boolean ready) {
		ready = this.ready;
		id = UUID.randomUUID().toString();
		type = "OrderStatus";
		
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
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
}
