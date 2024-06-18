package domain.entities;

import java.time.LocalDate;

public class Coupon {

  private final String code;
  private final double percentage;
  private final LocalDate expireDate;

  public Coupon(String code, double percentage) {
    this.code = code;
    this.percentage = percentage;
    this.expireDate = null;
  }

  public Coupon(String code, double percentage, LocalDate expireDate) {
    this.code = code;
    this.percentage = percentage;
    this.expireDate = expireDate;
  }

  public String getCode() {
    return code;
  }

  public LocalDate getExpireDate() {
    return expireDate;
  }

  public double getPercentage() {
    return percentage;
  }

  public boolean isValid(LocalDate today) {
    if (this.expireDate == null) return true;
    return this.expireDate.isAfter(today) || this.expireDate.isEqual(today);
  }

  public boolean isExpired(LocalDate today) {
    return !isValid(today);
  }

  public double calculateDiscount(double amount, LocalDate today) {
    if (this.isExpired(today)) return 0.0;
    return (amount * this.percentage) / 100.0;
  }
}
