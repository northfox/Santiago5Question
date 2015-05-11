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

    if (removableNumbers.size() != 0) {
      result = new BigDecimal(removableNumbers.remove(0));
      double addNumber = firstSumByRecursion(removableNumbers);
      result = addBigDecimal(result, addNumber);
    }
    return result.doubleValue();
  }

  private BigDecimal addBigDecimal(BigDecimal result, double number) {
    BigDecimal addNumber = new BigDecimal(number);
    result = result.add(addNumber, new MathContext(4, RoundingMode.HALF_UP));
    return result;
  }

  public List<String> secondMerge(List<String> firstList,
      List<String> secondList) {
    List<String> result = new ArrayList<String>();
    int maxListSize = Math.max(firstList.size(), secondList.size());

    for (int i = 0; i < maxListSize; i++) {
      addUnlessEmpty(result, firstList, i);
      addUnlessEmpty(result, secondList, i);
    }

    return result;
  }

  private void addUnlessEmpty(
      List<String> result, List<String> list, int i) {
    if (list.size() > i) {
      result.add(list.get(i));
    }
  }
}
