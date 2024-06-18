package domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CouponTest {

  @Test
  void deveCriarCupomValido() {
    Coupon coupon = new Coupon("VALE20", 20L, LocalDate.of(2024, 5, 6));
    LocalDate today = LocalDate.of(2024, 5, 6);
    boolean isValid = coupon.isValid(today);
    Assertions.assertTrue(isValid);
  }

  @Test
  void deveCriarCupomExpirado() {
    Coupon coupon = new Coupon("VALE20", 20L, LocalDate.of(2024, 5, 6));
    LocalDate today = LocalDate.of(2024, 5, 7);
    boolean isExpired = coupon.isExpired(today);
    Assertions.assertTrue(isExpired);
  }

  @Test
  void deveCriarCupomValidoCalcularDesconto() {
    Coupon coupon = new Coupon("VALE20", 20L, LocalDate.of(2024, 5, 6));
    LocalDate today = LocalDate.of(2024, 5, 6);
    double discount = coupon.calculateDiscount(1000.0, today);
    Assertions.assertEquals(200L, discount);
  }
}
