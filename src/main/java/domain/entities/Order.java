package domain.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

  private final List<OrderItem> orderItems;
  private Coupon coupon;
  private double freight;
  private LocalDate date;
  private final FreightCalculator freightCalculator;

  public Order(String cpf) {
    Cpf cpf1 = new Cpf(cpf);
    this.orderItems = new ArrayList<>();
    this.coupon = null;
    this.freight = 0.0;
    this.date = LocalDate.now();
    this.freightCalculator = null;
  }

  public Order(String cpf, LocalDate date) {
    Cpf cpf1 = new Cpf(cpf);
    this.orderItems = new ArrayList<>();
    this.coupon = null;
    this.date = date;
    this.freightCalculator = null;
    this.freight = 0.0;
  }

  public Order(String cpf, LocalDate date, FreightCalculator freightCalculator) {
    Cpf cpf1 = new Cpf(cpf);
    this.orderItems = new ArrayList<>();
    this.coupon = null;
    this.date = date;
    this.freightCalculator = freightCalculator;
    this.freight = 0.0;
  }

  public Order(String cpf, FreightCalculator freightCalculator) {
    Cpf cpf1 = new Cpf(cpf);
    this.orderItems = new ArrayList<>();
    this.coupon = null;
    this.freightCalculator = freightCalculator;
    this.date = LocalDate.now();
    this.freight = 0.0;
  }

  public double getTotal() {
    double total = 0.0;
    for (OrderItem orderItem : this.orderItems) {
      total += orderItem.getTotal();
    }
    if (this.coupon != null) {
      total -= this.coupon.calculateDiscount(total, this.date);
    }
    if (this.freightCalculator != null) {
      total += this.getFreight();
    }
    return total;
  }

  public void addItem(Item item, Long quantity) {
    this.orderItems.add(new OrderItem(item.getIdItem(), item.getPrice(), quantity));
    if (this.freightCalculator != null)
      this.freight += this.freightCalculator.calculate(item) * quantity;
  }

  public void addCoupon(Coupon coupon) {
    this.coupon = coupon;
  }

  public double getFreight() {
    return this.freight;
  }
}
