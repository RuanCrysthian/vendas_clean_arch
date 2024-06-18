package domain.entities;

public class DefaultFreightCalculator implements FreightCalculator {
  @Override
  public double calculate(Item item) {
    double freight = (1000 * item.getVolume() * (item.getDensity() / 100L));
    double minFreight = 10L;
    return Math.max(minFreight, freight);
  }
}
