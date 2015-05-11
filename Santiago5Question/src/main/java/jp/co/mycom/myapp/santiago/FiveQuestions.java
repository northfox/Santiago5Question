package jp.co.mycom.myapp.santiago;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class FiveQuestions {
  
  public double firstSumByForLoop(List<Double> numbers) {
    // use bigdecimal because solve float error
    BigDecimal result = new BigDecimal(0.0);

    for (Double number : numbers) {
      result = addBigDecimal(result, number);
    }
    return result.doubleValue();
  }

  public double firstSumByWhileLoop(List<Double> numbers) {
    // use bigdecimal because solve float error
    BigDecimal result = new BigDecimal(0.0);
    List<Double> removableNumbers = new ArrayList<Double>(numbers);

    while (removableNumbers.size() != 0) {
      result = addBigDecimal(result, removableNumbers.remove(0));
    }
    return result.doubleValue();
  }

  public double firstSumByRecursion(List<Double> numbers) {
    // use bigdecimal because solve float error
    BigDecimal result = new BigDecimal(0.0);
    List<Double> removableNumbers = new ArrayList<Double>(numbers);
    
    result =
        firstSumByRecursionBody(removableNumbers, removableNumbers.remove(0));

    return result.doubleValue();
  }
  
  private BigDecimal firstSumByRecursionBody(List<Double> removableNumbers,
      double number) {
    BigDecimal result = new BigDecimal(number);

    if (removableNumbers.size() != 0) {
      BigDecimal addNumber =
          firstSumByRecursionBody(removableNumbers, removableNumbers.remove(0));
      result = addBigDecimal(result, addNumber.doubleValue());
    }
    return result;
  }

  private BigDecimal addBigDecimal(BigDecimal result, double number) {
    BigDecimal addNumber = new BigDecimal(number);
    result = result.add(addNumber, new MathContext(4, RoundingMode.HALF_UP));
    return result;
  }
}
