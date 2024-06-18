package domain.repository;

import domain.entities.Order;

public interface OrderRepository {
  void save(Order order);
}
