package br.com.eighteenburguers.operation.core.usecase;

import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.exception.BusinessException;

public interface CreateOrderUseCase {

	Order execute(Order order) throws BusinessException;
}
