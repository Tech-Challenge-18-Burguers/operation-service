package br.com.eighteenburguers.operation.application.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.eighteenburguers.operation.adapter.OrderMapper;
import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.repository.OrderRepository;
import br.com.eighteenburguers.operation.core.valueobject.order.OrderFilter;
import br.com.eighteenburguers.operation.core.valueobject.pagination.PageData;
import br.com.eighteenburguers.operation.core.valueobject.pagination.Pageable;
import br.com.eighteenburguers.operation.infra.repository.OrderRepositoryJpa;
import br.com.eighteenburguers.operation.infra.repository.entity.OrderEntity;

@ExtendWith(MockitoExtension.class)
class OrderRepositorySQLTest {

	@Mock
	OrderRepositoryJpa jpaRepository;
	
	OrderMapper mapper;
	
	@BeforeEach
	void setup() {
		this.mapper = Mappers.getMapper(OrderMapper.class);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	void shouldBeList() {
		Mockito.when(jpaRepository.findAll(Mockito.any(Example.class), Mockito.any(PageRequest.class))).thenReturn(Mockito.mock(Page.class));
		OrderRepository repository = new OrderRepositorySQL(jpaRepository, mapper);
		PageData<Order> page = repository.list(new OrderFilter(), new Pageable());
		assertNotNull(page);
	}
	
	@Test
	void shouldBeFindByIdEmpty() {
		OrderRepository repository = new OrderRepositorySQL(jpaRepository, mapper);
		Optional<Order> optional = repository.findById(1L);
		assertTrue(optional.isEmpty());
	}
	
	@Test
	void shouldBeFindById() {
		Mockito.when(jpaRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(new OrderEntity()));
		OrderRepository repository = new OrderRepositorySQL(jpaRepository, mapper);
		Optional<Order> optional = repository.findById(1L);
		assertTrue(optional.isPresent());
	}
	
	@Test
	void shouldBeSave() {
		OrderRepository repository = new OrderRepositorySQL(jpaRepository, mapper);
		Order order = repository.save(new Order());
		assertNotNull(order);
	}
}
