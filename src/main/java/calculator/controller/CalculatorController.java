package calculator.controller;

import java.math.BigInteger;

import calculator.view.InputView;

/**
 * 계산기 애플리케이션의 제어를 담당하는 컨트롤러 클래스
 * 사용자 입력을 받아 계산 서비스를 호출하고 결과를 출력하는 역할을 수행합니다.
 */
public class CalculatorController {
    private final CalculatorService calculatorService;

    /**
     * CalculatorController 생성자
     * 
     * @param calculatorService
     */
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    /**
     * 계산기 애플리케이션의 "메인 실행 로직"
     * 사용자로부터 입력을 받아 계산을 수행하고 결과를 출력합니다.
     * 잘못된 입력이 들어온 경우 에러 메시지를 출력합니다.
     */
    public void run() {
        try {
            // 입력
            String input = InputView.readInput();
            // 합계 계산
            BigInteger result = calculatorService.calculateSum(input);
            // 결과 출력
            OutputView.printResult(result);
        } catch (IllegalArgumentException e) {
            // 예외 발생 시 에러 메시지 출력
            ErrorView.printError(e.getMessage());
        }
    }
}
