package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import org.junit.jupiter.api.Test;
import railway.super_express_surcharge_calculation.domain.common.FixtureAmountValue;

import static org.junit.jupiter.api.Assertions.*;

class NotDiscountedFreeSeatSuperExpressSurchargeTest {
  @Test
  public void adjust() {
    assertEquals(
        FixtureAmountValue.get(4960),
        FixtureNotDiscountedFreeSeatSuperExpressSurchargeValue.get(5490).getAmount());
  }
}
