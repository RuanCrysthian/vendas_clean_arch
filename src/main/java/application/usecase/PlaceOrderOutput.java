package application.usecase;

public class PlaceOrderOutput {
  private double total;

  public PlaceOrderOutput(double total) {
    this.total = total;
  }

  public double getTotal() {
    return total;
  }

}
