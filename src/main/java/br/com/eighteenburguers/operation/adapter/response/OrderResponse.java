package br.com.eighteenburguers.operation.adapter.response;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import br.com.eighteenburguers.operation.core.entity.OrderStatus;
import lombok.Data;

@Data
public class OrderResponse {

    private Long id;
    private String customerId;
    private BigDecimal amount = BigDecimal.ZERO;
    private OrderStatus status;
    private Instant createdAt;
    private Instant updatedAt;
    private List<OrderItemResponse> items;
}
