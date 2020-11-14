package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import railway.super_express_surcharge_calculation.domain.common.FixtureDepartureMonthDayValue;

import static org.junit.jupiter.api.Assertions.*;

class OffPeakTermTest {
  @ParameterizedTest
  @CsvSource({"1, 16", "1, 20", "1, 30"})
  public void include(int month, int dayOfMonth) {
    assertTrue(OffPeakTerm.include(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }

  @ParameterizedTest
  @CsvSource({"1, 15", "1, 31"})
  public void notInclude(int month, int dayOfMonth) {
    assertFalse(OffPeakTerm.include(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }
}
