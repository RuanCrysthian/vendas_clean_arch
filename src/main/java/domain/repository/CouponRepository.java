package domain.repository;

import domain.entities.Coupon;

public interface CouponRepository {
  Coupon findByCode(String code);
}
