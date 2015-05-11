package jp.co.mycom.myapp.santiago;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;

//問題1
//forループ、whileループ、および再帰を使用して、リスト内の数字の合計を計算する3つの関数を記述せよ。
//
//問題2
//交互に要素を取ることで、2つのリストを結合する関数を記述せよ。
//例えば [a, b, c]と[1, 2, 3]という2つのリストを与えると、関数は [a, 1, b, 2, c, 3]を返す。
//
//問題3
//最初の100個のフィボナッチ数のリストを計算する関数を記述せよ。
//定義では、フィボナッチ数列の最初の2つの数字は0と1で、次の数は前の2つの合計となる。
//例えば最初の10個のフィボナッチ数列は、0, 1, 1, 2, 3, 5, 8, 13, 21, 34となる。
//
//問題4
//正の整数のリストを与えられたとき、数を並び替えて可能な最大数を返す関数を記述せよ。
//例えば、[50, 2, 1, 9]が与えられた時、95021が答えとなる(解答例)。
//
//問題5
//1,2,…,9の数をこの順序で、”+”、”-“、またはななにもせず結果が100となるあらゆる組合せを出力するプログラムを記述せよ。
//例えば、1 + 2 + 34 – 5 + 67 – 8 + 9 = 100となる(解答例)

@RunWith(Enclosed.class)
public class FiveQuestionsTest {

  private static FiveQuestions sut;

  // 問題1
  // forループ、whileループ、および再帰を使用して、リスト内の数字の合計を計算する3つの関数を記述せよ。
  //
  @RunWith(Theories.class)
  public static class FirstQuestion {

    public FirstQuestion() {
      sut = new FiveQuestions();
    }

    @DataPoints
    public static Fixture[] PARAMs = {
        new Fixture(generateNumbers(1.0), 1.0),
        new Fixture(generateNumbers(1.0, 2.0, 3.0), 6.0),
        new Fixture(generateNumbers(1.1, 2.3, 3.1), 6.5),
        new Fixture(generateNumbers(-1.1, -2.3, -3.1), -6.5),
        new Fixture(generateNumbers(0.5, -1.1, 2.3, -3.1), -1.4),
    };

    @Theory
    public void ByForLoop(Fixture p) {
      double actual = sut.firstSumByForLoop(p.numbers);
      String msg = String.format("When numbers is <%s>", p.numbers);
      assertThat(msg, actual, is(p.expected));
    }

    @Theory
    public void ByWhileLoop(Fixture p) {
      double actual = sut.firstSumByWhileLoop(p.numbers);
      String msg = String.format("When numbers is <%s>", p.numbers);
      assertThat(msg, actual, is(p.expected));
    }

    @Theory
    public void ByRecursion(Fixture p) {
      double actual = sut.firstSumByRecursion(p.numbers);
      String msg = String.format("When numbers is <%s>", p.numbers);
      assertThat(msg, actual, is(p.expected));
    }

    @SuppressWarnings("serial")
    private static ArrayList<Double> generateNumbers(double... numbers) {
      return new ArrayList<Double>() {
        {
          for (double number : numbers) {
            add(number);
          }
        }
      };
    }

    static class Fixture {
      List<Double> numbers;
      double expected;

      Fixture(List<Double> numbers, double expected) {
        this.numbers = numbers;
        this.expected = expected;
      }
    }
  }

  // 問題2
  // 交互に要素を取ることで、2つのリストを結合する関数を記述せよ。
  // 例えば [a, b, c]と[1, 2, 3]という2つのリストを与えると、関数は [a, 1, b, 2, c, 3]を返す。
  @RunWith(Theories.class)
  public static class SecondQuestion {

    public SecondQuestion() {
      sut = new FiveQuestions();
    }

    @DataPoints
    public static Fixture[] PARAMs = {
        new Fixture(generateList("a"), generateList("1"),
            generateList("a", "1")),
        new Fixture(generateList("a", "b", "c"), generateList("1", "2", "3"),
            generateList("a", "1", "b", "2", "c", "3")),
        new Fixture(generateList("a", "b"), generateList("1", "2", "3"),
            generateList("a", "1", "b", "2", "3")),
        new Fixture(generateList(), generateList("1", "2", "3"),
            generateList("1", "2", "3")),
        new Fixture(generateList(), generateList(),
            generateList()),
    };

    @Theory
    public void mergeList(Fixture p) {
      // expect
      List<String> firstList = p.firstList;
      List<String> secondList = p.secondList;
      List<String> expected = p.expected;

      // exercise
      List<String> actual = sut.secondMerge(firstList, secondList);

      // verify
      String msg =
          String.format("When first list is <%s>, second list is <%s>",
              p.firstList, p.secondList);
      assertThat(msg, actual, is(expected));
    }

    @SuppressWarnings("serial")
    private static ArrayList<String> generateList(String... args) {
      return new ArrayList<String>() {
        {
          for (String arg : args) {
            add(arg);
          }
        }
      };
    }

    static class Fixture {
      List<String> firstList;
      List<String> secondList;
      List<String> expected;

      Fixture(List<String> firstList, List<String> secondList,
          List<String> expected) {
        this.firstList = firstList;
        this.secondList = secondList;
        this.expected = expected;
      }
    }
  }

  // 問題3
  // 最初の100個のフィボナッチ数のリストを計算する関数を記述せよ。
  // 定義では、フィボナッチ数列の最初の2つの数字は0と1で、次の数は前の2つの合計となる。
  // 例えば最初の10個のフィボナッチ数列は、0, 1, 1, 2, 3, 5, 8, 13, 21, 34となる。
  @RunWith(Theories.class)
  public static class ThirdQuestion {
    public ThirdQuestion() {
      sut = new FiveQuestions();
    }

    @DataPoints
    public static Fixture[] PARAMs = {
        new Fixture(0, new BigDecimal("0")),
        new Fixture(1, new BigDecimal("0")),
        new Fixture(2, new BigDecimal("1")),
        new Fixture(3, new BigDecimal("2")),
        new Fixture(10, new BigDecimal("88")),
        new Fixture(50, new BigDecimal("20365011073")),
        new Fixture(100, new BigDecimal("573147844013817084100")),
    };

    @Theory
    public void calcFibonacciNumbers(Fixture p) {
      BigDecimal actual = sut.thirdCalcFibonacciNumbers(p.numberOfLoop);
      String msg = String.format("When numberOfLoop is <%s>", p.numberOfLoop);
      assertThat(msg, actual, is(p.expected));
    }

    static class Fixture {
      int numberOfLoop;
      BigDecimal expected;

      Fixture(int numberOfLoop, BigDecimal expected) {
        this.numberOfLoop = numberOfLoop;
        this.expected = expected;
      }
    }
  }

  // 問題4
  // 正の整数のリストを与えられたとき、数を並び替えて可能な最大数を返す関数を記述せよ。
  // 例えば、[50, 2, 1, 9]が与えられた時、95021が答えとなる(解答例)
  @RunWith(Theories.class)
  public static class FourthQuestion {

    @DataPoints
    public static Fixture[] PARAMs = {
        new Fixture(generateNumbers(), new BigDecimal("0")),
        new Fixture(generateNumbers(1), new BigDecimal("1")),
        new Fixture(generateNumbers(1, 2), new BigDecimal("21")),
        new Fixture(generateNumbers(2, 5, 1, 3), new BigDecimal("5321")),
        new Fixture(generateNumbers(50, 2, 1, 9), new BigDecimal("95021")),
    };

    public FourthQuestion() {
      sut = new FiveQuestions();
    }

    @Theory
    public void bigNumberSort(Fixture p) {
      BigDecimal actual = sut.fourthSort(p.targetList);
      String msg = String.format("When targetList is <%s>", p.targetList);
      assertThat(msg, actual, is(p.expected));
    }

    @SuppressWarnings("serial")
    private static ArrayList<Integer> generateNumbers(int... numbers) {
      return new ArrayList<Integer>() {
        {
          for (int number : numbers) {
            add(number);
          }
        }
      };
    }

    static class Fixture {
      List<Integer> targetList;
      BigDecimal expected;

      Fixture(List<Integer> targetList, BigDecimal expected) {
        this.targetList = targetList;
        this.expected = expected;
      }
    }
  }

  // 問題5
  // 1,2,…,9の数をこの順序で、”+”、”-“、またはななにもせず結果が100となるあらゆる組合せを出力するプログラムを記述せよ。
  // 例えば、1 + 2 + 34 – 5 + 67 – 8 + 9 = 100となる(解答例)
}
