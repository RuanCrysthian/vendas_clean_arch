package application.usecase;

public class OrderItemInput {
  private Long idItem;
  private Long quantity;

  public OrderItemInput(Long idItem, Long quantity) {
    this.idItem = idItem;
    this.quantity = quantity;
  }

  public Long getIdItem() {
    return idItem;
  }

  public Long getQuantity() {
    return quantity;
  }

}
