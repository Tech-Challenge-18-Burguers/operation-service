package br.com.eighteenburguers.operation.core.usecase;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.entity.OrderItem;
import br.com.eighteenburguers.operation.core.exception.BusinessException;
import br.com.eighteenburguers.operation.core.exception.OrderNotFoundException;
import br.com.eighteenburguers.operation.core.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
class GetOrderByIdUseCaseImplTest {

	@Mock
	OrderRepository repository;
	
	@Test
	void shouldBeGetById() throws BusinessException {
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(mockOrder()));
		GetOrderByIdUseCase usecase = new GetOrderByIdUseCaseImpl(repository);
		Order order = usecase.execute(1L);
		assertNotNull(order);
	}
	
	@Test
	void shouldBeNotGetById() {
		Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		GetOrderByIdUseCase usecase = new GetOrderByIdUseCaseImpl(repository);
		assertThrows(OrderNotFoundException.class, () -> usecase.execute(1L));
	}
	
	Order mockOrder() {
		return new Order(1L, UUID.randomUUID().toString(), new ArrayList<OrderItem>());
	}
}
