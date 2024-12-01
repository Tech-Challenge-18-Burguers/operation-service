package br.com.eighteenburguers.operation.event;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.eighteenburguers.operation.adapter.request.OrderRequest;
import br.com.eighteenburguers.operation.controller.OrderController;
import br.com.eighteenburguers.operation.core.exception.BusinessException;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class OrderEvent {

	private final OrderController controller;
	
	@Transactional
	public void onMessage(OrderRequest request) throws BusinessException {
		controller.create(request);
	}
}
