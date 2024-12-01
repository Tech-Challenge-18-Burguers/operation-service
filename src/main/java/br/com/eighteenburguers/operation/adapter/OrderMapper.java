package br.com.eighteenburguers.operation.adapter;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.ReportingPolicy.IGNORE;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.eighteenburguers.operation.adapter.request.OrderItemRequest;
import br.com.eighteenburguers.operation.adapter.request.OrderRequest;
import br.com.eighteenburguers.operation.adapter.response.OrderResponse;
import br.com.eighteenburguers.operation.core.entity.Order;
import br.com.eighteenburguers.operation.core.entity.OrderItem;
import br.com.eighteenburguers.operation.core.valueobject.order.OrderFilter;
import br.com.eighteenburguers.operation.infra.repository.entity.OrderEntity;

@Mapper(unmappedTargetPolicy = IGNORE, nullValueCheckStrategy = ALWAYS)
public interface OrderMapper {

	@Mapping(target = "items", source = "items")
	Order toEntity(OrderRequest order);
	
	@Mapping(target = "name", source = "product.name")
	@Mapping(target = "observation", source = "observation")
	@Mapping(target = "productId", source = "product.id")
	@Mapping(target = "quantity", source = "quantity")
	OrderItem toOrderItem(OrderItemRequest item);
	
	OrderResponse toResponse(Order order);
	
	OrderEntity ofFilter(OrderFilter filter);
	
	Order toEntity(OrderEntity entity);

	OrderEntity toOrderEntity(Order order);
}
