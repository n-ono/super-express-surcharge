package railway.super_express_surcharge_calculation.api;

import io.vavr.API;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import railway.super_express_surcharge_calculation.api.response.SuperExpressSurchargeCalculationApiResponse;
import railway.super_express_surcharge_calculation.domain.catalogue.CatalogueRepository;
import railway.super_express_surcharge_calculation.domain.common.*;
import railway.super_express_surcharge_calculation.domain.discount.DiscountRepository;
import railway.super_express_surcharge_calculation.domain.super_express_surcharge.SuperExpressSurcharge;
import railway.super_express_surcharge_calculation.service.SuperExpressSurchargeCalculationService;

import java.time.MonthDay;

import static io.vavr.API.$;

@RestController
@AllArgsConstructor
public class SuperExpressSurchargeCalculationApi {
  @Autowired private final SuperExpressSurchargeCalculationService service;
  @Autowired private final CatalogueRepository catalogueRepository;
  @Autowired private final DiscountRepository discountRepository;

  @RequestMapping(value = "/calculate", method = RequestMethod.GET)
  public SuperExpressSurchargeCalculationApiResponse calculate(
      @RequestParam(name = "train-type") String trainType,
      @RequestParam(name = "seat-type") String seatType,
      @RequestParam(name = "destination") String destination,
      @RequestParam(name = "children") int children,
      @RequestParam(name = "adults") int adults,
      @RequestParam(name = "departure-month-day") String departureMonthDay) {
    SuperExpressSurcharge superExpressSurcharge =
        service.calculate(
            getTrainType(trainType),
            getSeatType(seatType),
            getDestination(destination),
            getPassenger(children, adults),
            getDepartureMonthDay(departureMonthDay));
    return new SuperExpressSurchargeCalculationApiResponse(
        superExpressSurcharge.getAmount().getValue());
  }

  private TrainType getTrainType(String trainType) {
    return API.Match(trainType)
        .of(API.Case($("nozomi"), TrainType.NOZOMI), API.Case($("hikari"), TrainType.HIKARI));
  }

  private SeatType getSeatType(String seatType) {
    return API.Match(seatType)
        .of(API.Case($("free"), SeatType.FREE), API.Case($("reserved"), SeatType.RESERVED));
  }

  private Destination getDestination(String destination) {
    return API.Match(destination)
        .of(
            API.Case($("shinosaka"), Destination.SHINOSAKA),
            API.Case($("himeji"), Destination.HIMEJI));
  }

  private Passenger getPassenger(int children, int adults) {
    return new Passenger(children, adults);
  }

  private DepartureMonthDay getDepartureMonthDay(String departureMonthDay) {
    final int month = Integer.parseInt(departureMonthDay.substring(0, 2));
    final int dayOfMonth = Integer.parseInt(departureMonthDay.substring(2, 4));
    return DepartureMonthDay.from(MonthDay.of(month, dayOfMonth));
  }
}
