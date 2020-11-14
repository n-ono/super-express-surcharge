package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import java.time.MonthDay;

public class FixtureSeasonEndMonthDayValue {
  public static SeasonEndMonthDay get(int month, int dayOfMonth) {
    return SeasonEndMonthDay.from(MonthDay.of(month, dayOfMonth));
  }
}
