package railway.super_express_surcharge_calculation.infrastructure.catalogue;

import io.vavr.API;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import railway.super_express_surcharge_calculation.domain.catalogue.CatalogueRepository;
import railway.super_express_surcharge_calculation.domain.common.Amount;
import railway.super_express_surcharge_calculation.domain.common.Destination;
import railway.super_express_surcharge_calculation.domain.common.SeatType;
import railway.super_express_surcharge_calculation.domain.common.TrainType;
import railway.super_express_surcharge_calculation.infrastructure.catalogue.response.CatalogueResponse;

import java.util.Objects;

import static io.vavr.API.$;

@Repository
@AllArgsConstructor
public class CatalogueRepositoryImpl implements CatalogueRepository {
  public static final String URL =
      "http://catalogue:8080/catalogue/basic-super-express-surcharge?train-type={trainType}&seat-type={seatType}&destination={destination}";

  @Autowired private final RestTemplate restTemplate;

  @Override
  public Amount findBy(TrainType trainType, SeatType seatType, Destination destination) {
    return Amount.from(
        Objects.requireNonNull(
                restTemplate.getForObject(
                    URL,
                    CatalogueResponse.class,
                    getTrainType(trainType),
                    getSeatType(seatType),
                    getDestination(destination)))
            .getAmountValue());
  }

  private String getTrainType(TrainType trainType) {
    return API.Match(trainType)
        .of(API.Case($(TrainType.NOZOMI), "nozomi"), API.Case($(TrainType.HIKARI), "hikari"));
  }

  private String getSeatType(SeatType seatType) {
    return API.Match(seatType)
        .of(API.Case($(SeatType.FREE), "free"), API.Case($(SeatType.RESERVED), "reserved"));
  }

  private String getDestination(Destination destination) {
    return API.Match(destination)
        .of(
            API.Case($(Destination.SHINOSAKA), "shinosaka"),
            API.Case($(Destination.HIMEJI), "himeji"));
  }
}
