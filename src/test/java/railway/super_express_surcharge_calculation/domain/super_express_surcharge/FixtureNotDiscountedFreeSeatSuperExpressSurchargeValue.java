package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import railway.super_express_surcharge_calculation.domain.common.Amount;

public class FixtureNotDiscountedFreeSeatSuperExpressSurchargeValue {
  public static NotDiscountedFreeSeatSuperExpressSurcharge get(int n) {
    return NotDiscountedFreeSeatSuperExpressSurcharge.from(Amount.from(n));
  }
}
