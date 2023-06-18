package racing.domain;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;


public class Car {
  String carName;
  private Car(String carName) {
    this.carName = carName;
  }

  public static Car of(String carName){
    if(!Car.isValid(carName)){
      throw new IllegalArgumentException("자동차의 이름값을 확인해주세요");
    }
    return new Car(carName);
  }

  public static boolean isValid(String carName){
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
    Car car = (Car) o;
    return Objects.equals(carName, car.carName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName);
  }
}
