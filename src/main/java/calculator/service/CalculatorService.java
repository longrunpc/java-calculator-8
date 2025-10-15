package calculator.service;

/**
 * 계산 서비스 인터페이스
 */
public interface CalculatorService {
    /**
     * 문자열을 입력받아 계산 결과를 문자열로 반환하는 메서드
     * 
     * @param input
     * @return
     */
    String calculateSum(String input);
}
