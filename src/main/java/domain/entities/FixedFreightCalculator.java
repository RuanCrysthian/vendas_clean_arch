package domain.entities;

public class FixedFreightCalculator implements FreightCalculator {
  @Override
  public double calculate(Item item) {
    return 10.0;
  }
}
