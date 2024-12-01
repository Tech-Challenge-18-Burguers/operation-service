package br.com.eighteenburguers.operation.core.usecase;

import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.exception.BusinessException;
import br.com.eighteenburguers.operation.core.valueobject.order.OrderFilter;
import br.com.eighteenburguers.operation.core.valueobject.pagination.PageData;
import br.com.eighteenburguers.operation.core.valueobject.pagination.Pageable;

public interface ListOrdersUseCase {

	PageData<Order> execute(OrderFilter filter, Pageable pageable) throws BusinessException;
}
