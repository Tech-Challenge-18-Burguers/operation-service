package br.com.eighteenburguers.operation.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.eighteenburguers.operation.adapter.OrderMapper;
import br.com.eighteenburguers.operation.adapter.request.OrderRequest;
import br.com.eighteenburguers.operation.adapter.response.OrderResponse;
import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.exception.BusinessException;
import br.com.eighteenburguers.operation.core.usecase.CreateOrderUseCase;
import br.com.eighteenburguers.operation.core.usecase.GetOrderByIdUseCase;
import br.com.eighteenburguers.operation.core.usecase.ListOrdersUseCase;
import br.com.eighteenburguers.operation.core.valueobject.order.OrderFilter;
import br.com.eighteenburguers.operation.core.valueobject.pagination.PageData;
import br.com.eighteenburguers.operation.core.valueobject.pagination.Pageable;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class OrderController {

	private final ListOrdersUseCase listOrdersUseCase;
	private final GetOrderByIdUseCase getOrderByIdUseCase;
	private final CreateOrderUseCase createOrderUseCase;
	private final OrderMapper mapper;
	
	public PageData<OrderResponse> list(final OrderFilter filter, Pageable pageable) throws BusinessException {
		PageData<Order> page = listOrdersUseCase.execute(filter, pageable);
		List<OrderResponse> orders = page.getData().stream().map(mapper::toResponse).toList();
		return PageData.clone(orders, page);
	}
	
	public OrderResponse getById(final Long id) throws BusinessException {
		Order order = getOrderByIdUseCase.execute(id);
		return mapper.toResponse(order);
	}
	
	public OrderResponse create(OrderRequest orderRequest) throws BusinessException {
		Order order = createOrderUseCase.execute(mapper.toEntity(orderRequest));
		return mapper.toResponse(order);
	}
}
