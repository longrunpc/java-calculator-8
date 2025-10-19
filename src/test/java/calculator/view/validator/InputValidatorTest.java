package calculator.view.validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("입력 검증 테스트")
class InputValidatorTest {

    @Nested
    @DisplayName("공백 검증 테스트")
    class WhitespaceValidationTest {

        @Test
        @DisplayName("공백이 없는 정상 입력")
        void validateInputWithoutWhitespace() {
            // given
            String input = "1,2,3";

            // when
            InputValidator.validateInput(input);

            // then
            assertThat(input).isEqualTo("1,2,3");
            
        }

        @Test
        @DisplayName("공백이 포함된 입력 - 예외 발생")
        void validateInputWithWhitespace() {
            // given
            String input = " 1, 2, 3 ";

            // when & then
            assertThatThrownBy(() -> InputValidator.validateInput(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("공백이 포함되어 있습니다.");
        }
    }
}

