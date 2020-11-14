package railway.super_express_surcharge_calculation.domain.catalogue;

import railway.super_express_surcharge_calculation.domain.common.Amount;
import railway.super_express_surcharge_calculation.domain.common.Destination;
import railway.super_express_surcharge_calculation.domain.common.SeatType;
import railway.super_express_surcharge_calculation.domain.common.TrainType;

public interface CatalogueRepository {
  Amount findBy(TrainType trainType, SeatType seatType, Destination destination);
}
