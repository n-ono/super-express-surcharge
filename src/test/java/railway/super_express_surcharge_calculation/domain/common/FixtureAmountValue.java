package railway.super_express_surcharge_calculation.domain.common;

public class FixtureAmountValue {
  public static Amount get(int n) {
    return Amount.from(n);
  }

  public static Amount zero() {
    return Amount.from(0);
  }
}
