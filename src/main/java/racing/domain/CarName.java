package racing.domain;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class CarName {

  private final String carName;

  private CarName(String carName) {
    this.carName = carName;

  }

  public static CarName of(String carName) {
    if (!CarName.isValid(carName)) {
      throw new IllegalArgumentException("자동차의 이름이 오류가 있습니다.");
    }
    return new CarName(carName.trim());
  }

  public static boolean isValid(String carName) {
    return !StringUtils.isBlank(carName) && carName.length() <= 5;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarName carName1 = (CarName) o;
    return Objects.equals(carName, carName1.carName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName);
  }
}
