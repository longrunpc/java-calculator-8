package calculator.model.parser;

import static org.assertj.core.api.Assertions.*;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


@Tag("unit")
@DisplayName("파싱 단위 테스트")
class ParserTest {

    private Parser parser;

    @Nested
    @DisplayName("문자열 구분자로 숫자 리스트를 파싱하는 테스트")
    class DelimiterParserTest {

        @BeforeEach
        void setUp() {
            parser = new DelimiterParser();
        }

        @Test
        @DisplayName("빈 문자열 입력 시 빈 리스트 반환")
        void parseEmptyString() {
            // given
            String input = "";

            // when
            List<BigInteger> numbers = parser.parseNumbers(input);

            // then
            assertThat(numbers).isEmpty();
        }

        @Test
        @DisplayName("커스텀 구분자가 없는 숫자 리스트 파싱")
        void parseCommaSeparatedNumbers() {
            // given
            String input = "1,2:3";

            // when
            List<BigInteger> numbers = parser.parseNumbers(input);

            // then
            assertThat(numbers).isEqualTo(List.of(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3)));
        }
        
        @Test
        @DisplayName("커스텀 구분자가 있는 숫자 리스트 파싱")
        void parseCustomDelimiterSeparatedNumbers() {
            // given
            String input = "//;\\n1,2;3";

            // when
            List<BigInteger> numbers = parser.parseNumbers(input);

            // then
            assertThat(numbers).isEqualTo(List.of(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3)));
        }

        @Test
        @DisplayName("숫자 리스트 파싱 예외")
        void parseException() {
            // given
            String input = "//;\\n1:2[3";

            // when
            assertThatThrownBy(() -> parser.parseNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
        }
    }
}