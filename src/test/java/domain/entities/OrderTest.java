package domain.entities;

import domain.exception.CpfInvalidException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class OrderTest {

  @Test
  void deveCriarPedidoVazioComCpfValido() {
    String cpf = "839.435.452-10";
    Order order = new Order(cpf);
    double total = order.getTotal();
    Assertions.assertEquals(0.0, total);
  }

  @Test
  void deveCriarPedidoComCpfInvalido() {
    String cpf = "111.111.111-11";
    Assertions.assertThrows(CpfInvalidException.class, () -> new Order(cpf));
  }

  @Test
  void deveCriarPedidoComTresItens() {
    String cpf = "839.435.452-10";
    Order order = new Order(cpf);
    order.addItem(new Item(1L, "Musica", "CD", 30.0), 3L);
    order.addItem(new Item(1L, "Video", "DVD", 50.0), 1L);
    order.addItem(new Item(1L, "Video", "CD", 10.0), 2L);
    double total = order.getTotal();
    Assertions.assertEquals(160.0, total);
  }

  @Test
  void deveCriarPedidoComTresItensComCupomDeDesconto() {
    String cpf = "839.435.452-10";
    Order order = new Order(cpf);
    order.addItem(new Item(1L, "Musica", "CD", 30.0), 3L);
    order.addItem(new Item(1L, "Video", "DVD", 50.0), 1L);
    order.addItem(new Item(1L, "Video", "CD", 10.0), 2L);
    order.addCoupon(new Coupon("VALE20", 20.0));
    double total = order.getTotal();
    Assertions.assertEquals(128.0, total);
  }

  @Test
  void deveCriarPedidoComTresItensComCupomDeDescontoExpirado() {
    String cpf = "839.435.452-10";
    Order order = new Order(cpf, LocalDate.of(2024, 5, 7));
    order.addItem(new Item(1L, "Musica", "CD", 30.0), 3L);
    order.addItem(new Item(1L, "Video", "DVD", 50.0), 1L);
    order.addItem(new Item(1L, "Video", "CD", 10.0), 2L);
    order.addCoupon(new Coupon("VALE20", 20.0, LocalDate.of(2024, 5, 6)));
    double total = order.getTotal();
    Assertions.assertEquals(160.0, total);
  }

  @Test
  void deveCriarPedidoComTresItensCalcularFreteDefault() {
    String cpf = "839.435.452-10";
    Order order = new Order(cpf, new DefaultFreightCalculator());
    order.addItem(new Item(4L, "Instrumentos Musicais", "Guitarra", 1000L, 100L, 30L, 10L, 3L), 1L);
    order.addItem(new Item(5L, "Instrumentos Musicais", "Amplificador", 5000L, 100L, 50L, 50L, 20L), 1L);
    order.addItem(new Item(6L, "Acessórios", "Cabo", 30L, 10L, 10L, 10L, 0.9), 3L);
    double freight = order.getFreight();
    Assertions.assertEquals(260, freight);
  }

  @Test
  void deveCriarPedidoComTresItensCalcularFreteFixo() {
    String cpf = "839.435.452-10";
    Order order = new Order(cpf, new FixedFreightCalculator());
    order.addItem(new Item(4L, "Instrumentos Musicais", "Guitarra", 1000L, 100L, 30L, 10L, 3L), 1L);
    order.addItem(new Item(5L, "Instrumentos Musicais", "Amplificador", 5000L, 100L, 50L, 50L, 20L), 1L);
    order.addItem(new Item(6L, "Acessórios", "Cabo", 30L, 10L, 10L, 10L, 0.9), 3L);
    double freight = order.getFreight();
    Assertions.assertEquals(50.0, freight);
  }
}
