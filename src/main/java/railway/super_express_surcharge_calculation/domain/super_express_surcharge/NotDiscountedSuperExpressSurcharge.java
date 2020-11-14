package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import lombok.*;
import railway.super_express_surcharge_calculation.domain.common.Amount;

/**
 * 割引適用前の特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NotDiscountedSuperExpressSurcharge {
  @Getter private final Amount amount;

  public static NotDiscountedSuperExpressSurcharge from(
      NotDiscountedFreeSeatSuperExpressSurcharge notDiscountedFreeSeatSuperExpressSurcharge) {
    return new NotDiscountedSuperExpressSurcharge(
        notDiscountedFreeSeatSuperExpressSurcharge.getAmount());
  }

  public static NotDiscountedSuperExpressSurcharge from(
      NotDiscountedReservedSeatSuperExpressSurcharge
          notDiscountedReservedSeatSuperExpressSurcharge) {
    return new NotDiscountedSuperExpressSurcharge(
        notDiscountedReservedSeatSuperExpressSurcharge.getAmount());
  }
}
