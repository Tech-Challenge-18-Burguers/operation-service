package br.com.eighteenburguers.operation.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@Mock
	ListOrdersUseCase listOrdersUseCase;
	
	@Mock
	GetOrderByIdUseCase getOrderByIdUseCase;
	
	@Mock
	CreateOrderUseCase createOrderUseCase;
	
	OrderMapper mapper;
	
	@BeforeEach
	void setup() {
		this.mapper = Mappers.getMapper(OrderMapper.class);
	}
	
	@Test
	void shouldBeList() throws BusinessException {
		Mockito.when(listOrdersUseCase.execute(Mockito.any(), Mockito.any())).thenReturn(mockPageData());
		OrderController controller = new OrderController(listOrdersUseCase, getOrderByIdUseCase, createOrderUseCase, mapper);
		PageData<OrderResponse> response = controller.list(new OrderFilter(), new Pageable());
		assertNotNull(response);
	}
	
	@Test
	void shouldBeGetById() throws BusinessException {
		Mockito.when(getOrderByIdUseCase.execute(Mockito.anyLong())).thenReturn(new Order());
		OrderController controller = new OrderController(listOrdersUseCase, getOrderByIdUseCase, createOrderUseCase, mapper);
		OrderResponse response = controller.getById(1L);
		assertNotNull(response);
	}
	
	@Test
	void shouldBeCreate() throws BusinessException {
		Mockito.when(createOrderUseCase.execute(Mockito.any())).thenReturn(new Order());
		OrderController controller = new OrderController(listOrdersUseCase, getOrderByIdUseCase, createOrderUseCase, mapper);
		OrderResponse response = controller.create(new OrderRequest());
		assertNotNull(response);
	}
	
	PageData<Order> mockPageData() {
		PageData<Order> page = new PageData<>();
		page.setData(List.of());
		return page;
	}
}
