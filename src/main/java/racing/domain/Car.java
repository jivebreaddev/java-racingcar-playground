package racing.domain;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;


public class Car {

  CarName carName;

  private Car(CarName carName) {
    this.carName = carName;
  }

  public static Car of(String name) {
    CarName carName = CarName.of(name);
    return new Car(carName);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Car car = (Car) o;
    return Objects.equals(carName, car.carName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName);
  }
}
