package br.com.eighteenburguers.operation.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eighteenburguers.operation.infra.repository.entity.OrderEntity;

@Repository
public interface OrderRepositoryJpa extends JpaRepository<OrderEntity, Long> {
	
}
