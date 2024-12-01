package br.com.eighteenburguers.operation.core.usecase;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.javafaker.Faker;

import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.entity.OrderItem;
import br.com.eighteenburguers.operation.core.entity.OrderStatus;
import br.com.eighteenburguers.operation.core.exception.BusinessException;
import br.com.eighteenburguers.operation.core.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
class CreateOrderUseCaseImplTest {

	@Mock
	OrderRepository repository;

	Faker faker;
	
	@BeforeEach
	void setup() {
		this.faker = Faker.instance();
	}
	
	
	@Test
	void shouldBeCreate() throws BusinessException {
		Mockito.when(repository.save(Mockito.any())).thenReturn(mockOrder());
		
		CreateOrderUseCase usecase = new CreateOrderUseCaseImpl(repository);
		Order order = usecase.execute(new Order());
		assertNotNull(order);
	}
	
	Order mockOrder() {
		Order order = new Order();
		order.setAmount(BigDecimal.valueOf(faker.random().nextDouble()));
		order.setCreatedAt(Instant.now());
		order.setCustomerId(UUID.randomUUID().toString());
		order.setId(faker.random().nextLong());
		order.setItems(new ArrayList<OrderItem>());
		order.setStatus(OrderStatus.PAID);
		order.setUpdatedAt(Instant.now());
		order.setItems(List.of(mockItem()));
		return order;
	}
	
	OrderItem mockItem() {
		OrderItem item = new OrderItem();
		item.setId(faker.random().nextLong());
		item.setName(faker.commerce().productName());
		item.setObservation("");
		item.setProductId(faker.random().nextLong());
		item.setQuantity(faker.random().nextInt(1, 10));
		return item;
	}
}
