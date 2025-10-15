package calculator.model.calculator;

import static org.assertj.core.api.Assertions.*;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Nested
    @DisplayName("양수 값만 허용하는 계산기 테스트")
    class PositiveNumberCalculatorTest {

        Calculator calculator;

        @BeforeEach
        void setUp() {
            calculator = new PositiveNumberCalculator();
        }

        @Test
        @DisplayName("양수 값만 존재할 경우")
        void testPositiveNumberCalculator() {
            // given
            var numbers = List.of(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3));

            // when
            var result = calculator.calculateSum(numbers);

            // then
            assertThat(result).isEqualTo(BigInteger.valueOf(6));
        }

        @Test
        @DisplayName("음수 값이 포함되어 있는 경우")
        void testNegativeNumberCalculator() {
            // given
            var numbers = List.of(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(-3));

            // when
            assertThatThrownBy(() -> calculator.calculateSum(numbers))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
