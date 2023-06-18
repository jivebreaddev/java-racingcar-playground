package racing.domain;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarsTest {

  public static final String Names = "abc,cde,efg,jij,klm";
  public List<Car> carNames;
  public Car firstCar;
  public Car secondCar;
  public Car thirdCar;

  @BeforeEach
  void setUp() {
    firstCar = Car.of("abc", 3);
    secondCar = Car.of("def", 1);
    thirdCar = Car.of("ghi", 2);
    carNames = Arrays.asList(firstCar, secondCar, thirdCar);
  }

  @Test
  @DisplayName("리스트가 주어졌을때 자동차 생성")
  void carFactory() {
    //GIVEN

    //WHEN
    Cars cars = Cars.of(carNames);
    //THEN
    assertThat(cars.equals(Cars.of(carNames)));
  }

  @Test
  @DisplayName("자동차 1턴 진행하기")
  void carTurn() {
    //GIVEN
    Cars cars = Cars.of(carNames);
    RandomStrategy randomStrategy = new RandomMoveStrategy() {
      @Override
      public boolean isValid() {
        return true;
      }
    };
    //WHEN
    cars.play(randomStrategy);

    //THEN
    assertThat(firstCar.equalPosition(CarPosition.of(4)));
  }

  @Test
  @DisplayName("자동차 중에 제일 빠른 자동차 고르기")
  void carFastest() {
    //GIVEN

    //WHEN

    Cars cars = Cars.of(carNames);
    //THEN
    List<Car> car = cars.getWinners();
    assertThat(car.contains(Car.of("abc", 3)));

  }

}
