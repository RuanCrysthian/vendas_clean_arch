package domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderItemTest {

  @Test
  void deveCriarUmItemDoPedido() {
    OrderItem orderItem = new OrderItem(1L, 1000.0, 10.0);
    Assertions.assertEquals(10000.0, orderItem.getTotal());
  }
}
