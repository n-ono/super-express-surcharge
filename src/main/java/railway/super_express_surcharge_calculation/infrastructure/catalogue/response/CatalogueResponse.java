package railway.super_express_surcharge_calculation.infrastructure.catalogue.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatalogueResponse {
  @Getter @Setter private int amountValue;
}
