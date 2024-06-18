package domain.entities;

public class OrderItem {

  private Long idItem;
  private double price;
  private double quantity;

  public OrderItem(Long idItem, double price, double quantity) {
    this.idItem = idItem;
    this.price = price;
    this.quantity = quantity;
  }

  public Long getIdItem() {
    return idItem;
  }

  public void setIdItem(Long idItem) {
    this.idItem = idItem;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public double getTotal() {
    return this.price * this.quantity;
  }
}
