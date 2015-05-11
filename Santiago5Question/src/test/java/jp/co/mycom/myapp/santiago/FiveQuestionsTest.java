package jp.co.mycom.myapp.santiago;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
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
      sut = new FiveQuestions();
      double actual = sut.firstSumByForLoop(p.numbers);
      String msg = String.format("When numbers is <%s>", p.numbers);
      assertThat(msg, actual, is(p.expected));
    }

    @Theory
    public void ByWhileLoop(Fixture p) {
      sut = new FiveQuestions();
      double actual = sut.firstSumByWhileLoop(p.numbers);
      String msg = String.format("When numbers is <%s>", p.numbers);
      assertThat(msg, actual, is(p.expected));
    }

    @Theory
    public void ByRecursionLoop(Fixture p) {
      sut = new FiveQuestions();
      double actual = sut.firstSumByWhileLoop(p.numbers);
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

  public static class SecondQuestion {
    
  }
}
