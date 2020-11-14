package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import railway.super_express_surcharge_calculation.domain.common.DepartureMonthDay;

import java.time.MonthDay;

/**
 * シーズン終了月日
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SeasonEndMonthDay {
  private final MonthDay value;

  public static SeasonEndMonthDay from(MonthDay monthDay) {
    return new SeasonEndMonthDay(monthDay);
  }

  public boolean isBefore(DepartureMonthDay departureMonthDay) {
    return value.isBefore(departureMonthDay.getValue());
  }
}
