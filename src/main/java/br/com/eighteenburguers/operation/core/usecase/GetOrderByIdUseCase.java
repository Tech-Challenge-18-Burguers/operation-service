package br.com.eighteenburguers.operation.core.usecase;

import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.exception.BusinessException;

public interface GetOrderByIdUseCase {

	Order execute(Long id) throws BusinessException;
}
