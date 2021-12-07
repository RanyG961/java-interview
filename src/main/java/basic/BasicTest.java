package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * else return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    Integer res = i;
    if(n < 0 || i < 0)
      return Option.none();
    else if(n == 0)
    {
      return Option.of(1);
    }
    else if (i == 0)
    {
      return Option.of(0);
    }

    for (int nOccurrence = 1; nOccurrence < n; nOccurrence++)
    {
      res *= i;
    }

    if(res != 0)
    {
      return Option.of(res);
    }


    return Option.none();
  }
}
