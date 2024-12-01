package br.com.eighteenburguers.operation.core.usecase;

import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.exception.BusinessException;
import br.com.eighteenburguers.operation.core.repository.OrderRepository;

public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

	private final OrderRepository repository;

	public CreateOrderUseCaseImpl(OrderRepository repository) {
		this.repository = repository;
	}

	@Override
	public Order execute(Order order) throws BusinessException {
		return this.repository.save(order);
	}

}
