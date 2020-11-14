package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import railway.super_express_surcharge_calculation.domain.common.FixtureDepartureMonthDayValue;

import static org.junit.jupiter.api.Assertions.*;

class SeasonEndMonthDayTest {
  @Test
  public void isBefore() {
    assertTrue(
        FixtureSeasonEndMonthDayValue.get(9, 4).isBefore(FixtureDepartureMonthDayValue.get(9, 5)));
  }

  @ParameterizedTest
  @CsvSource({"9, 3", "9, 4"})
  public void isNotBefore(int month, int dayOfMonth) {
    assertFalse(
        FixtureSeasonEndMonthDayValue.get(9, 4)
            .isBefore(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }
}
