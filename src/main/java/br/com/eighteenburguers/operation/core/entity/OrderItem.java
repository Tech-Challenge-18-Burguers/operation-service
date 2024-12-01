package br.com.eighteenburguers.operation.core.entity;

public class OrderItem {

	private Long id;
	private Long productId;
	private String name;
	private Integer quantity;
	private String observation;

	public OrderItem(Long id, Long productId, String name, Integer quantity, String observation) {
		super();
		this.id = id;
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
		this.observation = observation;
	}

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

}
