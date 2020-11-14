package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import java.time.MonthDay;

public class FixtureSeasonStartMonthDayValue {
  public static SeasonStartMonthDay get(int month, int dayOfMonth) {
    return SeasonStartMonthDay.from(MonthDay.of(month, dayOfMonth));
  }
}
