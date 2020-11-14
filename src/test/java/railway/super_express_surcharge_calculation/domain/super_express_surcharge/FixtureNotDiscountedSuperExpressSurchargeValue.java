package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import railway.super_express_surcharge_calculation.domain.common.Amount;

public class FixtureNotDiscountedSuperExpressSurchargeValue {
  public static NotDiscountedSuperExpressSurcharge fromNotDiscountedFreeSeatSuperExpressSurcharge(
      int n) {
    return NotDiscountedSuperExpressSurcharge.from(
        NotDiscountedFreeSeatSuperExpressSurcharge.from(Amount.from(n)));
  }

  public static NotDiscountedSuperExpressSurcharge
      fromNotDiscountedReservedSeatSuperExpressSurcharge(int n) {
    return NotDiscountedSuperExpressSurcharge.from(
        NotDiscountedReservedSeatSuperExpressSurcharge.from((Amount.from(n))));
  }
}
