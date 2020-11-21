package railway.super_express_surcharge_calculation.infrastructure.discount;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import railway.super_express_surcharge_calculation.domain.common.Amount;
import railway.super_express_surcharge_calculation.domain.common.DepartureMonthDay;
import railway.super_express_surcharge_calculation.domain.common.Passenger;
import railway.super_express_surcharge_calculation.domain.discount.DiscountRepository;
import railway.super_express_surcharge_calculation.domain.super_express_surcharge.NotDiscountedSuperExpressSurcharge;
import railway.super_express_surcharge_calculation.domain.super_express_surcharge.SuperExpressSurcharge;
import railway.super_express_surcharge_calculation.infrastructure.discount.response.DiscountResponse;

import java.util.Objects;

@Repository
@AllArgsConstructor
public class DiscountRepositoryImpl implements DiscountRepository {
  public static final String URL =
      "http://discount:8080/discount_calculation/discount-super-express-surcharge?super-express-surcharge={superExpressSurcharge}&children={children}&adults={adults}&departure-month-day={departureMonthDay}";

  @Autowired private final RestTemplate restTemplate;

  @Override
  public SuperExpressSurcharge calculate(
      NotDiscountedSuperExpressSurcharge notDiscountedSuperExpressSurcharge,
      Passenger passenger,
      DepartureMonthDay departureMonthDay) {
    return SuperExpressSurcharge.from(
        Amount.from(
            Objects.requireNonNull(
                    restTemplate.getForObject(
                        URL,
                        DiscountResponse.class,
                        getAmount(notDiscountedSuperExpressSurcharge),
                        passenger.getChildren(),
                        passenger.getAdults(),
                        getDepartureMonthDay(departureMonthDay)))
                .getValue()));
  }

  private int getAmount(NotDiscountedSuperExpressSurcharge notDiscountedSuperExpressSurcharge) {
    return notDiscountedSuperExpressSurcharge.getAmount().getValue();
  }

  private String getDepartureMonthDay(DepartureMonthDay departureMonthDay) {
    return String.format(
        "%02d%02d", departureMonthDay.getMonthValue(), departureMonthDay.getDayOfMonth());
  }
}
