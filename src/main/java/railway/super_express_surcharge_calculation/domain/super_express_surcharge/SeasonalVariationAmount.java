package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import lombok.*;
import railway.super_express_surcharge_calculation.domain.common.Amount;
import railway.super_express_surcharge_calculation.domain.common.DepartureMonthDay;

/**
 * 季節変動料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SeasonalVariationAmount {
  @Getter private final Amount amount;

  public static SeasonalVariationAmount from(DepartureMonthDay departureMonthDay) {
    return OffPeakTerm.include(departureMonthDay)
        ? new SeasonalVariationAmount(Amount.from(-200))
        : PeakTerm.include(departureMonthDay)
            ? new SeasonalVariationAmount(Amount.from(200))
            : new SeasonalVariationAmount(Amount.from(0));
  }
}
