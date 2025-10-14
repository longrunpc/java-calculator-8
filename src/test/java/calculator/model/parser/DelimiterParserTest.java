package calculator.model.parser;

import static org.assertj.core.api.Assertions.*;

import java.math.BigInteger;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("문자열 구분자 파싱 테스트")
class DelimiterParserTest {

    private final Parser parser = new DelimiterParser();
    
    @Nested
    @DisplayName("문자열을 입력받아 숫자 리스트로 파싱하는 메서드")
    class ParseNumbers {
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
    }

}