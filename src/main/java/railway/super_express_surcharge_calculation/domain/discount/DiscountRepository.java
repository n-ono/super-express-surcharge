package railway.super_express_surcharge_calculation.domain.discount;

import railway.super_express_surcharge_calculation.domain.common.DepartureMonthDay;
import railway.super_express_surcharge_calculation.domain.common.Passenger;
import railway.super_express_surcharge_calculation.domain.super_express_surcharge.NotDiscountedSuperExpressSurcharge;
import railway.super_express_surcharge_calculation.domain.super_express_surcharge.SuperExpressSurcharge;

public interface DiscountRepository {
  SuperExpressSurcharge calculate(
      NotDiscountedSuperExpressSurcharge notDiscountedSuperExpressSurcharge,
      Passenger passenger,
      DepartureMonthDay departureMonthDay);
}
