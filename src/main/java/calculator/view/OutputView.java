package calculator.view;

/**
 * 출력 관련 View 클래스
 */
public class OutputView {
    
    /**
     * 계산 결과를 출력하는 메서드
     * 
     * @param result
     */
    public static void printResult(String result) {
        System.out.println("결과 : " + result);
    }

    /**
     * 에러 메시지를 출력하는 메서드
     * 
     * @param message
     */
    public static void printError(String message) {
        System.out.println(message);
    }
}
