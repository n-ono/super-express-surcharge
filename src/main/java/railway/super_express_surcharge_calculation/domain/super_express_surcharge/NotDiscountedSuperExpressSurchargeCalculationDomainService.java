package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import railway.super_express_surcharge_calculation.domain.common.Amount;
import railway.super_express_surcharge_calculation.domain.common.DepartureMonthDay;
import railway.super_express_surcharge_calculation.domain.common.SeatType;

/**
 * 割引適用前の特急料金を計算するドメインサービス
 */
public class NotDiscountedSuperExpressSurchargeCalculationDomainService {
  public static NotDiscountedSuperExpressSurcharge calculate(
      Amount amount, SeatType seatType, DepartureMonthDay departureMonthDay) {
    return seatType.isFree()
        ? calculateForFreeSeat(amount)
        : calculateForReservedSeat(amount, departureMonthDay);
  }

  private static NotDiscountedSuperExpressSurcharge calculateForFreeSeat(Amount amount) {
    NotDiscountedFreeSeatSuperExpressSurcharge notDiscountedFreeSeatSuperExpressSurcharge =
        NotDiscountedFreeSeatSuperExpressSurcharge.from(amount);
    return NotDiscountedSuperExpressSurcharge.from(notDiscountedFreeSeatSuperExpressSurcharge);
  }

  private static NotDiscountedSuperExpressSurcharge calculateForReservedSeat(
      Amount amount, DepartureMonthDay departureMonthDay) {
    SeasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge
        seasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge =
            SeasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge.from(amount);
    NotDiscountedReservedSeatSuperExpressSurcharge notDiscountedReservedSeatSuperExpressSurcharge =
        seasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge.adjust(
            SeasonalVariationAmount.from(departureMonthDay));
    return NotDiscountedSuperExpressSurcharge.from(notDiscountedReservedSeatSuperExpressSurcharge);
  }
}
