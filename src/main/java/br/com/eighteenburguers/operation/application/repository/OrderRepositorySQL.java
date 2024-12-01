package br.com.eighteenburguers.operation.application.repository;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.eighteenburguers.operation.adapter.OrderMapper;
import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.repository.OrderRepository;
import br.com.eighteenburguers.operation.core.valueobject.order.OrderFilter;
import br.com.eighteenburguers.operation.core.valueobject.pagination.PageData;
import br.com.eighteenburguers.operation.core.valueobject.pagination.Pageable;
import br.com.eighteenburguers.operation.infra.repository.OrderRepositoryJpa;
import br.com.eighteenburguers.operation.infra.repository.entity.OrderEntity;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class OrderRepositorySQL implements OrderRepository {

	private final OrderRepositoryJpa repository;
	private final OrderMapper mapper;

	@Override
	public PageData<Order> list(OrderFilter filter, Pageable pageable) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues()
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase();
		OrderEntity order = mapper.ofFilter(filter);
		Page<OrderEntity> page = repository.findAll(Example.of(order, matcher), pageable.getPageRequest());
		return PageData.from(page.getContent().stream().map(mapper::toEntity).toList(), page);
	}

	@Override
	public Optional<Order> findById(Long id) {
		Optional<OrderEntity> optional = repository.findById(id);
		if(optional.isEmpty()) return Optional.empty();
		OrderEntity entity = optional.get();
		return Optional.ofNullable(mapper.toEntity(entity));
	}

	@Override
	public Order save(Order order) {
		OrderEntity entity = mapper.toOrderEntity(order);
		repository.save(entity);
		return order;
	}

}
