package br.com.eighteenburguers.operation.core.usecase;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.entity.OrderItem;
import br.com.eighteenburguers.operation.core.entity.OrderStatus;
import br.com.eighteenburguers.operation.core.exception.BusinessException;
import br.com.eighteenburguers.operation.core.repository.OrderRepository;
import br.com.eighteenburguers.operation.core.valueobject.order.OrderFilter;
import br.com.eighteenburguers.operation.core.valueobject.pagination.PageData;
import br.com.eighteenburguers.operation.core.valueobject.pagination.Pageable;

@ExtendWith(MockitoExtension.class)
class ListOrdersUseCaseImplTest {

	@Mock
	OrderRepository repository;
	
	@Test
	void shouldBeList() throws BusinessException {
		Mockito.when(repository.list(Mockito.any(), Mockito.any())).thenReturn(mockPageData());
		ListOrdersUseCase usecase = new ListOrdersUseCaseImpl(repository);
		PageData<Order> page = usecase.execute(new OrderFilter(), new Pageable());
		assertNotNull(page);
	}
	
	PageData<Order> mockPageData() {
		Order order = mockOrder();
		List<Order> list = new ArrayList<>();
		list.add(order);
		PageData<Order> page = new PageData<>();
		page.setData(list);
		return page;
	}
	
	Order mockOrder() {
		return new Order(1L, UUID.randomUUID().toString(), new ArrayList<OrderItem>(), BigDecimal.ZERO, OrderStatus.PAID, Instant.now(), Instant.now());
	}
}
