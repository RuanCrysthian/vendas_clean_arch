package infra.repository.memory;

import java.util.ArrayList;

import domain.entities.Coupon;
import domain.repository.CouponRepository;

public class CouponRepositoryMemory implements CouponRepository {

  private ArrayList<Coupon> coupons;

  public CouponRepositoryMemory() {
    this.coupons = new ArrayList<>();
    this.coupons.add(new Coupon("VALE20", 20));
  }

  @Override
  public Coupon findByCode(String code) {
    for (Coupon coupon : coupons) {
      if (coupon.getCode().equals(code)) {
        return coupon;
      }
    }
    return null;
  }

}
