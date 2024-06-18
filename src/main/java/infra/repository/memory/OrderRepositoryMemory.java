package infra.repository.memory;

import java.util.ArrayList;
import java.util.List;

import domain.entities.Order;
import domain.repository.OrderRepository;

public class OrderRepositoryMemory implements OrderRepository {

  private List<Order> orders = new ArrayList<>();

  public OrderRepositoryMemory() {
    this.orders = new ArrayList<>();
  }

  @Override
  public void save(Order order) {
    this.orders.add(order);
  }

}
