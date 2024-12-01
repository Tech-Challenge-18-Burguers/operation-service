package br.com.eighteenburguers.operation.adapter.request;

import lombok.Data;

@Data
public class OrderItemRequest {

	private Product product;
	private Integer quantity;
	private String observation;

}
