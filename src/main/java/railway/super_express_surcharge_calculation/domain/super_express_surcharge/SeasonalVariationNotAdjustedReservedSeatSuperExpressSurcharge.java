package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import railway.super_express_surcharge_calculation.domain.common.Amount;

/**
 * 季節変動料金調整前の指定席特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SeasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge {
  private final Amount amount;

  public static SeasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge from(Amount amount) {
    return new SeasonalVariationNotAdjustedReservedSeatSuperExpressSurcharge(amount);
  }

  public NotDiscountedReservedSeatSuperExpressSurcharge adjust(
      SeasonalVariationAmount seasonalVariationAmount) {
    return NotDiscountedReservedSeatSuperExpressSurcharge.from(
        amount.plus(seasonalVariationAmount.getAmount()));
  }
}
