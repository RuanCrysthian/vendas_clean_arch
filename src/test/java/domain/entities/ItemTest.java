package domain.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ItemTest {

  @Test
  void deveCalcularVolume() {
    Item item = new Item(1L, "Teste", "Teste", 10.0,
      20L, 15.0, 10.0, 1.0);
    double volume = item.getVolume();
    Assertions.assertEquals(0.003, volume);
  }

  @Test
  void deveCalcularDensidade() {
    Item item = new Item(1L, "Teste", "Teste", 10.0,
      20L, 15.0, 10.0, 1.0);
    double density = item.getDensity();
    Assertions.assertEquals(333.33, density);
  }
}
