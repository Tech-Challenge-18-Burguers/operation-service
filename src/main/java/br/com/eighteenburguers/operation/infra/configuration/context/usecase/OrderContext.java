package br.com.eighteenburguers.operation.infra.configuration.context.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.eighteenburguers.operation.core.repository.OrderRepository;
import br.com.eighteenburguers.operation.core.usecase.CreateOrderUseCase;
import br.com.eighteenburguers.operation.core.usecase.CreateOrderUseCaseImpl;
import br.com.eighteenburguers.operation.core.usecase.GetOrderByIdUseCase;
import br.com.eighteenburguers.operation.core.usecase.GetOrderByIdUseCaseImpl;
import br.com.eighteenburguers.operation.core.usecase.ListOrdersUseCase;
import br.com.eighteenburguers.operation.core.usecase.ListOrdersUseCaseImpl;

@Component
public class OrderContext {

	@Bean
	CreateOrderUseCase createOrderUseCase(OrderRepository repository) {
		return new CreateOrderUseCaseImpl(repository);
	}
	
	@Bean
	GetOrderByIdUseCase getOrderByIdUseCase(OrderRepository repository) {
		return new GetOrderByIdUseCaseImpl(repository);
	}
	
	@Bean
	ListOrdersUseCase listOrdersUseCase(OrderRepository repository) {
		return new ListOrdersUseCaseImpl(repository);
	}
}
