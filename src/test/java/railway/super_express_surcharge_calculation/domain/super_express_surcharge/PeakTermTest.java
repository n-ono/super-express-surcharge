package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import railway.super_express_surcharge_calculation.domain.common.FixtureDepartureMonthDayValue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PeakTermTest {
  @ParameterizedTest
  @CsvSource({"12, 25", "1, 10", "1, 1"})
  public void include(int month, int dayOfMonth) {
    assertTrue(PeakTerm.include(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }

  @ParameterizedTest
  @CsvSource({"12, 24", "1, 11"})
  public void notInclude(int month, int dayOfMonth) {
    assertFalse(PeakTerm.include(FixtureDepartureMonthDayValue.get(month, dayOfMonth)));
  }
}
