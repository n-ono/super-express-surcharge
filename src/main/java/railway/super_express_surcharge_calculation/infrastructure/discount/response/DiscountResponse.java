package railway.super_express_surcharge_calculation.infrastructure.discount.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscountResponse {
  @Getter @Setter private int discountAmountValue;
}
