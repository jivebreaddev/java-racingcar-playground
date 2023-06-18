package racing.domain;

import java.util.Random;

public class RandomMoveStrategy implements RandomStrategy {

  @Override
  public int randomNumber() {
    Random random = new Random();
    int randomNumber = random.nextInt(RandomStrategy.MAX_BOUND);
    return randomNumber;
  }

  @Override
  public boolean isValid() {
    return randomNumber() >= 4;
  }

}
