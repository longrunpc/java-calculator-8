package calculator;

import calculator.controller.CalculatorController;
import calculator.model.calculator.PositiveNumberCalculator;
import calculator.model.parser.DelimiterParser;
import calculator.service.CalculatorServiceImpl;

public class Application {
    public static void main(String[] args) {
        // 의존성 주입
        var parser = new DelimiterParser();
        var calculator = new PositiveNumberCalculator();
        var calculatorService = new CalculatorServiceImpl(parser, calculator);
        var calculatorController = new CalculatorController(calculatorService);
        
        // 계산 로직 실행
        calculatorController.calculateSumByString();
    }
}
