package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarTest {


  public static final String CAR_NAME = "five";
  public static final String ILLEGAL_NAME = "fiveguys";

  @Test
  @DisplayName("자동차 이름은 5글자 이하일때 생성된다.")
  void CarNameLessThanFive(){
    //GIVEN

    //WHEN
    Car car = Car.of(CAR_NAME);
    //THEN

    assertThat(car.equals(Car.of(CAR_NAME))).isEqualTo(true);
  }
  @Test
  @DisplayName("자동차 이름은 5글자 초과일때 오류를 던진다")
  void CarName(){
    //GIVEN

    //WHEN
    Throwable thrown = catchThrowable(() -> Car.of(ILLEGAL_NAME));
    //THEN
    assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("랜덤 값이 4이 상인 경우 자동차는 전진한다.")
  void CarMove(){
    //GIVEN
    Car car = Car.of(CAR_NAME);

    //WHEN

    //THEN
  }

  @Test
  @DisplayName("자동차를 toString 했을때 position에 따른 -- 갯수가 달라진다.")
  void CarToString(){
    //GIVEN
    //WHEN
    //THEN
  }

}
