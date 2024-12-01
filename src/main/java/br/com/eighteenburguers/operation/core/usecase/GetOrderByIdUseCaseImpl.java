package br.com.eighteenburguers.operation.core.usecase;

import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.exception.BusinessException;
import br.com.eighteenburguers.operation.core.exception.OrderNotFoundException;
import br.com.eighteenburguers.operation.core.repository.OrderRepository;

public class GetOrderByIdUseCaseImpl implements GetOrderByIdUseCase {

	private final OrderRepository repository;

	public GetOrderByIdUseCaseImpl(OrderRepository repository) {
		this.repository = repository;
	}

	@Override
	public Order execute(Long id) throws BusinessException {
		return repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
	}
}
