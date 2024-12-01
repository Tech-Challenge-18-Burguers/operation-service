package br.com.eighteenburguers.operation.core.usecase;

import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.exception.BusinessException;
import br.com.eighteenburguers.operation.core.repository.OrderRepository;
import br.com.eighteenburguers.operation.core.valueobject.order.OrderFilter;
import br.com.eighteenburguers.operation.core.valueobject.pagination.PageData;
import br.com.eighteenburguers.operation.core.valueobject.pagination.Pageable;

public class ListOrdersUseCaseImpl implements ListOrdersUseCase {

	private final OrderRepository repository;

	public ListOrdersUseCaseImpl(OrderRepository repository) {
		this.repository = repository;
	}

	@Override
	public PageData<Order> execute(OrderFilter filter, Pageable pageable) throws BusinessException {
		return this.repository.list(filter, pageable);
	}

}
