package railway.super_express_surcharge_calculation.domain.super_express_surcharge;

import lombok.*;
import railway.super_express_surcharge_calculation.domain.common.Amount;

/**
 * 特急料金
 */
@EqualsAndHashCode
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SuperExpressSurcharge {
  @Getter private final Amount amount;

  public static SuperExpressSurcharge from(Amount amount) {
    return new SuperExpressSurcharge(amount);
  }
}
