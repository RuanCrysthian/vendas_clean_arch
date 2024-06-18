package application.usecase;

import domain.entities.Coupon;
import domain.entities.DefaultFreightCalculator;
import domain.entities.FreightCalculator;
import domain.entities.Item;
import domain.entities.Order;
import domain.repository.CouponRepository;
import domain.repository.ItemRepository;
import domain.repository.OrderRepository;

public class PlaceOrder {
  private CouponRepository couponRepository;
  private ItemRepository itemRepository;
  private OrderRepository orderRepository;

  public PlaceOrder(CouponRepository couponRepository, ItemRepository itemRepository, OrderRepository orderRepository) {
    this.couponRepository = couponRepository;
    this.itemRepository = itemRepository;
    this.orderRepository = orderRepository;
  }

  public PlaceOrderOutput execute(PlaceOrderInput input) {
    FreightCalculator freightCalculator = new DefaultFreightCalculator();
    Order order = new Order(input.getCpf(), input.getDate(), freightCalculator);
    for (OrderItemInput orderItem : input.getOrderItems()) {
      Item item = itemRepository.findById(orderItem.getIdItem());
      if (item == null) {
        throw new ItemNotFoundException("Item not Found!");
      }
      order.addItem(item, orderItem.getQuantity());
    }
    if (input.getCoupon() != null) {
      Coupon coupon = couponRepository.findByCode(input.getCoupon());
      if (coupon != null) {
        order.addCoupon(coupon);
      }
    }
    this.orderRepository.save(order);
    double total = order.getTotal();
    return new PlaceOrderOutput(total);
  }
}
