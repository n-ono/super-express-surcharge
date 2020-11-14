package railway.super_express_surcharge_calculation.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import railway.super_express_surcharge_calculation.domain.catalogue.CatalogueRepository;
import railway.super_express_surcharge_calculation.domain.common.*;
import railway.super_express_surcharge_calculation.domain.discount.DiscountRepository;
import railway.super_express_surcharge_calculation.domain.super_express_surcharge.NotDiscountedSuperExpressSurcharge;
import railway.super_express_surcharge_calculation.domain.super_express_surcharge.NotDiscountedSuperExpressSurchargeCalculationDomainService;
import railway.super_express_surcharge_calculation.domain.super_express_surcharge.SuperExpressSurcharge;

@Service
@AllArgsConstructor
public class SuperExpressSurchargeCalculationService {
  @Autowired private final CatalogueRepository catalogueRepository;
  @Autowired private final DiscountRepository discountRepository;

  public SuperExpressSurcharge calculate(
      TrainType trainType,
      SeatType seatType,
      Destination destination,
      Passenger passenger,
      DepartureMonthDay departureMonthDay) {
    Amount amount = catalogueRepository.findBy(trainType, seatType, destination);
    NotDiscountedSuperExpressSurcharge notDiscountedSuperExpressSurcharge =
        NotDiscountedSuperExpressSurchargeCalculationDomainService.calculate(
            amount, seatType, departureMonthDay);
    return discountRepository.calculate(
        notDiscountedSuperExpressSurcharge, passenger, departureMonthDay);
  }
}
