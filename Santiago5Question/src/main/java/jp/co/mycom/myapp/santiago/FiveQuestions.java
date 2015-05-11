package jp.co.mycom.myapp.santiago;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solve the questions of Santiago 5
 * 
 * ・問題1
 * forループ、whileループ、および再帰を使用して、リスト内の数字の合計を計算する3つの関数を記述せよ。
 * 
 * ・問題2
 * 交互に要素を取ることで、2つのリストを結合する関数を記述せよ。
 * 例えば [a, b, c]と[1, 2, 3]という2つのリストを与えると、関数は [a, 1, b, 2, c, 3]を返す。
 * 
 * ・問題3
 * 最初の100個のフィボナッチ数のリストを計算する関数を記述せよ。
 * 定義では、フィボナッチ数列の最初の2つの数字は0と1で、次の数は前の2つの合計となる。
 * 例えば最初の10個のフィボナッチ数列は、0, 1, 1, 2, 3, 5, 8, 13, 21, 34となる。
 * 
 * ・問題4
 * 正の整数のリストを与えられたとき、数を並び替えて可能な最大数を返す関数を記述せよ。
 * 例えば、[50, 2, 1, 9]が与えられた時、95021が答えとなる(解答例)。
 * 
 * ・問題5
 * 1,2,…,9の数をこの順序で、”+”、”-“、またはななにもせず結果が100となるあらゆる組合せを出力するプログラムを記述せよ。
 * 例えば、1 + 2 + 34 – 5 + 67 – 8 + 9 = 100となる(解答例)
 * 
 * @author northfox
 */
public class FiveQuestions {

  /*
   * ・問題1
   * forループ、whileループ、および再帰を使用して、リスト内の数字の合計を計算する3つの関数を記述せよ。
   */
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

  /*
   * ・問題2
   * 交互に要素を取ることで、2つのリストを結合する関数を記述せよ。
   * 例えば [a, b, c]と[1, 2, 3]という2つのリストを与えると、関数は [a, 1, b, 2, c, 3]を返す。
   */
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

  /*
   * ・問題3
   * 最初の100個のフィボナッチ数のリストを計算する関数を記述せよ。
   * 定義では、フィボナッチ数列の最初の2つの数字は0と1で、次の数は前の2つの合計となる。
   * 例えば最初の10個のフィボナッチ数列は、0, 1, 1, 2, 3, 5, 8, 13, 21, 34となる。
   */
  private static final int THIRD_START_NO = 1;

  public BigDecimal thirdCalcFibonacciNumbers(int numberOfLoop) {
    BigDecimal result = new BigDecimal(0);
    BigDecimal theSecondNumber = new BigDecimal(0);
    BigDecimal previousNumber = new BigDecimal(1);

    for (int i = THIRD_START_NO; i < numberOfLoop; i++) {
      BigDecimal nextNumber = theSecondNumber.add(previousNumber);
      result = result.add(previousNumber);

      theSecondNumber = previousNumber;
      previousNumber = nextNumber;
    }

    return result;
  }

  /*
   * ・問題4
   * 正の整数のリストを与えられたとき、数を並び替えて可能な最大数を返す関数を記述せよ。
   * 例えば、[50, 2, 1, 9]が与えられた時、95021が答えとなる(解答例)。
   */
  public BigDecimal fourthSort(List<Integer> targetList) {
    BigDecimal result;
    
    if(targetList.size() < 1) {
      return new BigDecimal(0);
    }
    
    List<String> charSortableList = new ArrayList<String>();
    for (Integer number : targetList) {
      charSortableList.add(number.toString());
    }
    
    charSortableList.sort((a, b) -> b.compareTo(a));
    
    String bigNumber = "";
    for (String number : charSortableList) {
      bigNumber += number;
    }
    result = new BigDecimal(bigNumber);
    
    return result;
  }

  /*
   * ・問題5
   * 1,2,…,9の数をこの順序で、”+”、”-“、またはななにもせず結果が100となるあらゆる組合せを出力するプログラムを記述せよ。
   * 例えば、1 + 2 + 34 – 5 + 67 – 8 + 9 = 100となる(解答例)
   */
}
