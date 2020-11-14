package railway.super_express_surcharge_calculation.domain.common;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AmountTest {
  @ParameterizedTest
  @CsvSource({"10010, 10010", "10011, 10010"})
  public void adjust(int src, int expectedAmount) {
    assertEquals(FixtureAmountValue.get(expectedAmount), FixtureAmountValue.get(src));
  }

  @Test
  public void plus() {
    assertEquals(
        FixtureAmountValue.get(100), FixtureAmountValue.get(50).plus(FixtureAmountValue.get(50)));
  }

  @Test
  public void minus() {
    assertEquals(
        FixtureAmountValue.get(90), FixtureAmountValue.get(100).minus(FixtureAmountValue.get(10)));
  }
}
