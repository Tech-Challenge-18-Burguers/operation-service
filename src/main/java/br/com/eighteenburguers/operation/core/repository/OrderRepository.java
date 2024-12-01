package br.com.eighteenburguers.operation.core.repository;

import java.util.Optional;

import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.valueobject.order.OrderFilter;
import br.com.eighteenburguers.operation.core.valueobject.pagination.PageData;
import br.com.eighteenburguers.operation.core.valueobject.pagination.Pageable;

public interface OrderRepository {

	PageData<Order> list(OrderFilter filter, Pageable pageable);
	
	Optional<Order> findById(Long id);
	
	Order save(Order order);
}
