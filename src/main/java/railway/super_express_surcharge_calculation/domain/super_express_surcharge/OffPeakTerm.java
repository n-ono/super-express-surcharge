package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import railway.super_express_surcharge_calculation.domain.common.DepartureMonthDay;

import java.time.Month;
import java.time.MonthDay;

/**
 * 閑散期間
 */
@EqualsAndHashCode
@ToString
public class OffPeakTerm {
  private static final SeasonStartMonthDay SEASON_START_MONTH_DAY =
      SeasonStartMonthDay.from(MonthDay.of(Month.JANUARY, 16));
  private static final SeasonEndMonthDay SEASON_END_MONTH_DAY =
      SeasonEndMonthDay.from(MonthDay.of(Month.JANUARY, 30));

  public static boolean include(DepartureMonthDay departureMonthDay) {
    return !(SEASON_START_MONTH_DAY.isAfter(departureMonthDay)
        || SEASON_END_MONTH_DAY.isBefore(departureMonthDay));
  }
}
