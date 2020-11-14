package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import lombok.*;
import railway.super_express_surcharge_calculation.domain.common.Amount;

/**
 * 割引適用前の自由席特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NotDiscountedFreeSeatSuperExpressSurcharge {
  private static final Amount YEARLY_FIXED_AMOUNT = Amount.from(530);
  @Getter private final Amount amount;

  public static NotDiscountedFreeSeatSuperExpressSurcharge from(Amount amount) {
    return new NotDiscountedFreeSeatSuperExpressSurcharge(adjust(amount));
  }

  private static Amount adjust(Amount amount) {
    return amount.minus(YEARLY_FIXED_AMOUNT);
  }
}
