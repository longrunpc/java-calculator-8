package calculator.view.validator;

import calculator.common.ErrorMessages;

/**
 * 입력 유효성 검증 클래스
 */
public class InputValidator {
    /**
     * 입력 유효성 검증 메서드
     * @param input
     */
    public static void validateInput(String input) {
        containsWhitespace(input);
    }
    
    /**
     * 입력에 공백이 포함되어 있는지 검증하는 메서드
     * @param input
     */
    private static void containsWhitespace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessages.WHITESPACE_INCLUDED);
        }
    }
}
