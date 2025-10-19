package calculator.common;

/**
 * 애플리케이션 전역에서 사용되는 에러 메시지 상수 클래스
 */
public class ErrorMessages {
    
    // 입력 검증 관련 에러 메시지
    public static final String WHITESPACE_INCLUDED = "공백이 포함되어 있습니다.";
    
    // 숫자 계산 관련 에러 메시지
    public static final String NON_POSITIVE_NUMBER_INCLUDED = "양수가 아닌 값이 포함되어 있습니다.";
    
    // 파싱 관련 에러 메시지
    public static final String INVALID_NUMBER_FORMAT = "정수로 변환할 수 없는 값이 포함되어 있습니다.";
    
    // private 생성자로 인스턴스화 방지
    private ErrorMessages() {
    }
}

