package br.com.eighteenburguers.operation.infra.repository.entity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UpdateTimestamp;

import br.com.eighteenburguers.operation.core.entity.OrderStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class OrderEntity {
    
    @Id
    private Long id;

    private UUID customerId;

    private BigDecimal amount;

    private OrderStatus status;
    
    private Instant createdAt;
    
    @UpdateTimestamp
    private Instant updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItemEntity> items;

    public void setItems(List<OrderItemEntity> items) {
        this.items = items;
        this.items.forEach(item -> item.setOrder(this));
    }
}
