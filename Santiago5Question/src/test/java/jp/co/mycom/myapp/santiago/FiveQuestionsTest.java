package jp.co.mycom.myapp.santiago;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

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

public class FiveQuestionsTest {
  
  private FiveQuestions sut;
  
  @Before
  public void before() {
    sut = new FiveQuestions();
  }

  @Test
  public void firstWithForLoopCanSumByOneNumber() {
    // expect
    double expected = 1.0;
    List<Double> numbers = new ArrayList<Double>() {
      {
        add(1.0);
      }
    };
    
    // exercise
    double actual = sut.firstSumWithForLoop(numbers);
    
    // verify
    assertThat(actual, is(expected));
  }

  @Test
  public void firstWithForLoopCanSumByNumbers() {
    // expect
    double expected = 6.0;
    List<Double> numbers = new ArrayList<Double>() {
      {
        add(1.0);
        add(2.0);
        add(3.0);
      }
    };
    
    // exercise
    double actual = sut.firstSumWithForLoop(numbers);
    
    // verify
    assertThat(actual, is(expected));
  }

  @Test
  public void firstWithForLoopCanSummaryByFloatingNumbers() {
    // expect
    double expected = 6.5;
    List<Double> numbers = new ArrayList<Double>() {
      {
        add(1.1);
        add(2.3);
        add(3.1);
      }
    };
    
    // exercise
    double actual = sut.firstSumWithForLoop(numbers);
    
    // verify
    assertThat(actual, is(expected));
  }

  @Test
  public void firstWithForLoopCanSummaryByMinusFloatingNumbers() {
    // expect
    double expected = -6.5;
    List<Double> numbers = new ArrayList<Double>() {
      {
        add(-1.1);
        add(-2.3);
        add(-3.1);
      }
    };
    
    // exercise
    double actual = sut.firstSumWithForLoop(numbers);
    
    // verify
    assertThat(actual, is(expected));
  }

  @Test
  public void firstWithForLoopCanSummaryByPlusAndMinusFloatingNumbers() {
    // expect
    double expected = -1.4;
    List<Double> numbers = new ArrayList<Double>() {
      {
        add(0.5);
        add(-1.1);
        add(2.3);
        add(-3.1);
      }
    };
    
    // exercise
    double actual = sut.firstSumWithForLoop(numbers);
    
    // verify
    assertThat(actual, is(expected));
  }

}
