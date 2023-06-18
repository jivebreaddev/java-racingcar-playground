package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> carList = new ArrayList<>();

  private Cars(List<Car> cars) {
    cars.forEach(car -> carList.add(car));
  }

  private Cars(String cars) {
    List<String> carNames = Arrays.stream(cars.split(",")).collect(Collectors.toList());
    carNames.forEach(car -> carList.add(Car.of(car)));
  }

  public static Cars of(List<Car> cars) {

    return new Cars(cars);
  }

  public void play(RandomStrategy randomStrategy) {
    carList.forEach(car -> car.move(randomStrategy));
  }
  private List<Car> findWinners(CarPosition maxPosition){
    List<Car> winners = new ArrayList<>();

    for(Car car: carList){
      if (car.isWinner(maxPosition)){
        winners.add(car);
      }
    }
    return winners;
  }

  private CarPosition getMaxPosition(){
    CarPosition maxPosition = CarPosition.of(0);
    for (Car car: carList){
      maxPosition = car.getMaxPosition(maxPosition);
    }
    return maxPosition;
  }

  public List<Car> getWinners(){
    CarPosition maxPosition = getMaxPosition();
    List<Car> winners = findWinners(maxPosition);

    return winners;
  }

}
