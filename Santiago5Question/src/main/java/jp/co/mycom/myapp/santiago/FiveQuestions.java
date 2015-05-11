package jp.co.mycom.myapp.santiago;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
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
    List<Double> removableNumbers = new ArrayList<Double>(numbers);

    while (removableNumbers.size() != 0) {
      BigDecimal addNumber = new BigDecimal(removableNumbers.remove(0));
      result = result.add(addNumber, mathContext);
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
    MathContext mathContext = new MathContext(4, RoundingMode.HALF_UP);
    BigDecimal addNumber = new BigDecimal(number);

    if (removableNumbers.size() != 0) {
      BigDecimal childAddNumber =
          firstSumByRecursionBody(removableNumbers, removableNumbers.remove(0));
      addNumber = addNumber.add(childAddNumber, mathContext);
    }
    return addNumber;
  }

}
