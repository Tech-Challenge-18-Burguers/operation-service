package br.com.eighteenburguers.operation.core.exception;

public class OrderNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1L;

	public OrderNotFoundException(Long id) {
		super("ORDNF001", String.format("Order %s not found", id));
	}
}
