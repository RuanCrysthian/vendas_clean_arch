package application.usecase;

import java.time.LocalDate;
import java.util.List;

public class PlaceOrderInput {
  private String cpf;
  private List<OrderItemInput> orderItems;
  private LocalDate date;
  private String coupon;

  public PlaceOrderInput(String cpf, List<OrderItemInput> orderItems, LocalDate date) {
    this.cpf = cpf;
    this.orderItems = orderItems;
    this.date = date;
    this.coupon = null;
  }

  public PlaceOrderInput(String cpf, List<OrderItemInput> orderItems, LocalDate date, String coupon) {
    this.cpf = cpf;
    this.orderItems = orderItems;
    this.date = date;
    this.coupon = coupon;
  }

  public String getCpf() {
    return cpf;
  }

  public List<OrderItemInput> getOrderItems() {
    return orderItems;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getCoupon() {
    return coupon;
  }

}
