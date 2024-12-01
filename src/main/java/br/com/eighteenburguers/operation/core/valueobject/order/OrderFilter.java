package br.com.eighteenburguers.operation.core.valueobject.order;

import br.com.eighteenburguers.operation.core.entity.OrderStatus;

public class OrderFilter {

	private OrderStatus status;

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

}
