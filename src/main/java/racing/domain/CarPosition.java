package racing.domain;

import java.math.BigInteger;
import java.util.Objects;

public class CarPosition {
  public final int carPosition;

  private CarPosition(int position) {
    this.carPosition = position;
  }

  public static CarPosition of(int position){
    if (!CarPosition.isValid(position)){
      throw new IllegalArgumentException("자동차의 position이 0이상 10이하가 아닙니다.");
    }

    return new CarPosition(position);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarPosition that = (CarPosition) o;
    return carPosition == that.carPosition;
  }

  @Override
  public String toString() {
    String line = "-";
    return line.repeat(carPosition);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carPosition);
  }

  public static boolean isValid(int position){
    return position >= 0 && position <= 10;
  }

  public CarPosition move() {
    return CarPosition.of(carPosition + 1);
  }
}
