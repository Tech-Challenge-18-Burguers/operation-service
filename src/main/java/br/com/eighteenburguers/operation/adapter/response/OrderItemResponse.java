package br.com.eighteenburguers.operation.adapter.response;

import lombok.Data;

@Data
public class OrderItemResponse {

	private Long productId;
	private String name;
	private Integer quantity;
	private String observation;
}
