package jp.co.mycom.myapp.santiago;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class FiveQuestions {

  public double firstSumByForLoop(List<Double> numbers) {
    // use bigdecimal because solve float error
    MathContext mathContext = new MathContext(4, RoundingMode.HALF_UP);
    BigDecimal result = new BigDecimal(0.0);

    for (Double number : numbers) {
      BigDecimal addNumber = new BigDecimal(number);
      result = result.add(addNumber, mathContext);
    }
    return result.doubleValue();
  }

  public double firstSumByWhileLoop(List<Double> numbers) {
    // use bigdecimal because solve float error
    MathContext mathContext = new MathContext(4, RoundingMode.HALF_UP);
    BigDecimal result = new BigDecimal(0.0);

    while(numbers.size() != 0) {
      BigDecimal addNumber = new BigDecimal(numbers.remove(0));
      result = result.add(addNumber, mathContext);
    }
    return result.doubleValue();
  }

}
