package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import lombok.*;
import railway.super_express_surcharge_calculation.domain.common.Amount;

/**
 * 割引適用前の指定席特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NotDiscountedReservedSeatSuperExpressSurcharge {
  @Getter private final Amount amount;

  public static NotDiscountedReservedSeatSuperExpressSurcharge from(Amount amount) {
    return new NotDiscountedReservedSeatSuperExpressSurcharge(amount);
  }
}
