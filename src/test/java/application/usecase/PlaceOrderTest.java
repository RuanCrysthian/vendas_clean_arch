package application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import infra.repository.memory.CouponRepositoryMemory;
import infra.repository.memory.ItemRepositoryMemory;
import infra.repository.memory.OrderRepositoryMemory;

class PlaceOrderTest {

  @Test
  void deveFazerUmPedido() {
    ItemRepositoryMemory itemRepository = new ItemRepositoryMemory();
    OrderRepositoryMemory orderRepository = new OrderRepositoryMemory();
    CouponRepositoryMemory couponRepository = new CouponRepositoryMemory();

    PlaceOrder placeOrder = new PlaceOrder(couponRepository, itemRepository, orderRepository);
    List<OrderItemInput> orderItems = Arrays.asList(
        new OrderItemInput(1L, 1L),
        new OrderItemInput(2L, 1L),
        new OrderItemInput(3L, 3L));
    LocalDate date = LocalDate.of(2021, 12, 10);

    PlaceOrderInput input = new PlaceOrderInput("839.435.452-10", orderItems, date, "VALE20");
    PlaceOrderOutput output = placeOrder.execute(input);

    assertEquals(138, output.getTotal());
  }

  @Test
  void deveFazerUmPedidoComCalculoDeFrete() {
    ItemRepositoryMemory itemRepository = new ItemRepositoryMemory();
    OrderRepositoryMemory orderRepository = new OrderRepositoryMemory();
    CouponRepositoryMemory couponRepository = new CouponRepositoryMemory();

    PlaceOrder placeOrder = new PlaceOrder(couponRepository, itemRepository, orderRepository);
    List<OrderItemInput> orderItems = Arrays.asList(
        new OrderItemInput(4L, 1L),
        new OrderItemInput(5L, 1L),
        new OrderItemInput(6L, 3L));
    LocalDate date = LocalDate.of(2021, 12, 10);

    PlaceOrderInput input = new PlaceOrderInput("839.435.452-10", orderItems, date);
    PlaceOrderOutput output = placeOrder.execute(input);

    assertEquals(6350, output.getTotal());
  }

  @Test
  void deveEnviarExceptionQuandoItemNaoForEncontrado() {
    ItemRepositoryMemory itemRepository = new ItemRepositoryMemory();
    OrderRepositoryMemory orderRepository = new OrderRepositoryMemory();
    CouponRepositoryMemory couponRepository = new CouponRepositoryMemory();

    PlaceOrder placeOrder = new PlaceOrder(couponRepository, itemRepository, orderRepository);
    List<OrderItemInput> orderItems = Arrays.asList(
        new OrderItemInput(8L, 1L));
    LocalDate date = LocalDate.of(2021, 12, 10);
    PlaceOrderInput input = new PlaceOrderInput("839.435.452-10", orderItems, date);

    Assertions.assertThrows(ItemNotFoundException.class, () -> placeOrder.execute(input));
  }
}
