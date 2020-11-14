package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import org.junit.jupiter.api.Test;
import railway.super_express_surcharge_calculation.domain.common.FixtureAmountValue;
import railway.super_express_surcharge_calculation.domain.common.FixtureDepartureMonthDayValue;
import railway.super_express_surcharge_calculation.domain.common.SeatType;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NotDiscountedSuperExpressSurchargeCalculationDomainServiceTest {
  @Test
  public void calculateForFreeSeat() {
    assertEquals(
        FixtureNotDiscountedSuperExpressSurchargeValue
            .fromNotDiscountedFreeSeatSuperExpressSurcharge(5490),
        NotDiscountedSuperExpressSurchargeCalculationDomainService.calculate(
            FixtureAmountValue.get(5490),
            SeatType.FREE,
            FixtureDepartureMonthDayValue.get(12, 25)));
  }

  @Test
  public void calculateForReservedSeat() {
    assertEquals(
        FixtureNotDiscountedSuperExpressSurchargeValue
            .fromNotDiscountedReservedSeatSuperExpressSurcharge(6010),
        NotDiscountedSuperExpressSurchargeCalculationDomainService.calculate(
            FixtureAmountValue.get(5810),
            SeatType.RESERVED,
            FixtureDepartureMonthDayValue.get(12, 25)));
  }
}
