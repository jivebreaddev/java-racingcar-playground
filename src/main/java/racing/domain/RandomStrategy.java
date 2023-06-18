package racing.domain;

public interface RandomStrategy {
  public static int MAX_BOUND = 10;
  int randomNumber();
  boolean isValid();
}
