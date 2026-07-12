package com.yk.utils.pmdstarter.app.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberUtilsTest {

  @Test
  void testNumberIsConverted() {
    // given:
    int number = 0;

    // when:
    String convertedNumber = NumberUtils.convertNumberToString(number);

    // then:
    assertThat(convertedNumber).isEqualTo("[0]");
  }

  @ParameterizedTest
  @CsvSource({
      "-3, false", // not positive
      "0, false", // not positive
      "10, false", // even
      "1, false", // odd, but not smaller than digit sum squared (1 < 1 is false)
      "3, true", // odd, digit sum 3 is odd, 3 < 9
      "23, true", // odd, digit sum 5 is odd, 23 < 25
      "11, false", // odd, but digit sum 2 is even
      "41, false", // odd, digit sum 5 is odd, but 41 > 25
  })
  void testIsSpecialNumber(int number, boolean expected) {
    // when:
    boolean isSpecial = NumberUtils.isSpecialNumber(number);

    // then:
    assertThat(isSpecial).isEqualTo(expected);
  }
}
