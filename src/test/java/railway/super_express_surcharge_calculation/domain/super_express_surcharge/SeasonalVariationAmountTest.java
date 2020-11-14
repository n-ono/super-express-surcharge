package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import org.junit.jupiter.api.Test;
import railway.super_express_surcharge_calculation.domain.common.FixtureAmountValue;
import railway.super_express_surcharge_calculation.domain.common.FixtureDepartureMonthDayValue;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeasonalVariationAmountTest {
  @Test
  public void peak() {
    SeasonalVariationAmount actual =
        SeasonalVariationAmount.from(FixtureDepartureMonthDayValue.get(12, 25));

    assertEquals(FixtureAmountValue.get(200), actual.getAmount());
  }

  @Test
  public void offPeak() {
    SeasonalVariationAmount actual =
        SeasonalVariationAmount.from(FixtureDepartureMonthDayValue.get(1, 20));

    assertEquals(FixtureAmountValue.get(-200), actual.getAmount());
  }

  @Test
  public void other() {
    SeasonalVariationAmount actual =
        SeasonalVariationAmount.from(FixtureDepartureMonthDayValue.get(9, 4));

    assertEquals(FixtureAmountValue.zero(), actual.getAmount());
  }
}
