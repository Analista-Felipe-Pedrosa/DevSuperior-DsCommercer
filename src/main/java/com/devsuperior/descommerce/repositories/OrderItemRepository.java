package com.devsuperior.descommerce.repositories;

import com.devsuperior.descommerce.entities.Order;
import com.devsuperior.descommerce.entities.OrderItem;
import com.devsuperior.descommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
