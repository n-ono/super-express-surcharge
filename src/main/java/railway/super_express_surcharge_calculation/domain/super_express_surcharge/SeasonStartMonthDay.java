package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import railway.super_express_surcharge_calculation.domain.common.DepartureMonthDay;

import java.time.MonthDay;

/**
 * シーズン開始月日
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SeasonStartMonthDay {
  private final MonthDay value;

  public static SeasonStartMonthDay from(MonthDay monthDay) {
    return new SeasonStartMonthDay(monthDay);
  }

  public boolean isAfter(DepartureMonthDay departureMonthDay) {
    return value.isAfter(departureMonthDay.getValue());
  }
}
