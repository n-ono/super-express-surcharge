package railway.super_express_surcharge_calculation.domain.common;

import java.time.MonthDay;

public class FixtureDepartureMonthDayValue {
  public static DepartureMonthDay get(int month, int dayOfMonth) {
    return DepartureMonthDay.from(MonthDay.of(month, dayOfMonth));
  }
}
