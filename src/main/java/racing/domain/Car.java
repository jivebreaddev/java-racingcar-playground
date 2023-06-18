package racing.domain;

import java.math.BigInteger;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;


public class Car {
  public static final int START_POSITION = 0;
  final CarName carName;
  CarPosition carPosition;

  private Car(CarName carName, CarPosition carPosition) {
    this.carName = carName;
    this.carPosition = carPosition;
  }

  public static Car of(String name) {
    CarName carName = CarName.of(name);
    CarPosition carPosition = CarPosition.of(START_POSITION);
    return new Car(carName, carPosition);
  }

  public static Car of(String name, int position) {
    CarName carName = CarName.of(name);
    CarPosition carPosition = CarPosition.of(position);

    return new Car(carName, carPosition);
  }

  @Override
  public String toString() {
    String line = "-";
    return
        carName + " : " + carPosition;
  }

  public boolean equalPosition(CarPosition otherCarPosition){
    return carPosition.equals(otherCarPosition);
  }
  public void move(RandomStrategy randomStrategy){
    if(randomStrategy.isValid()){
      carPosition = carPosition.move();
    }
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
    return Objects.equals(carName, car.carName) && Objects.equals(carPosition,
        car.carPosition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName, carPosition);
  }

  public CarPosition getMaxPosition(CarPosition maxPosition) {
    if (lessThan(maxPosition)){
      return maxPosition;
    }
    return carPosition;
  }

  private boolean lessThan(CarPosition position){
    return carPosition.getCarPosition() < position.getCarPosition();
  }

  public boolean isWinner(CarPosition maxPosition) {
    return carPosition.equals(maxPosition);
  }
}
