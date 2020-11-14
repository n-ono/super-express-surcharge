package railway.super_express_surcharge_calculation.domain.common;

/**
 * 座席区分
 * 自由 or 指定
 */
public enum SeatType {
  FREE,
  RESERVED;

  public boolean isFree() {
    return this == FREE;
  }
}
