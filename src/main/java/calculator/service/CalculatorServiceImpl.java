package calculator.service;

import java.math.BigInteger;
import java.util.List;

import calculator.model.calculator.Calculator;
import calculator.model.parser.Parser;

/**
 * 계산 서비스 구현 클래스
 */
public class CalculatorServiceImpl implements CalculatorService {

    private final Parser parser;
    private final Calculator calculator;

    /**
     * CalculatorServiceImpl 생성자
     * 
     * @param parser
     * @param calculator
     */
    public CalculatorServiceImpl(Parser parser, Calculator calculator) {
        this.parser = parser;
        this.calculator = calculator;
    }

    /**
     * 문자열을 입력받아 계산 결과를 문자열로 반환하는 메서드
     * 
     * @param input
     * @return
     */
    @Override
    public String calculateSum(String input) {
        // 입력값을 파싱하여 숫자 리스트로 변환
        List<BigInteger> numbers = parser.parseNumbers(input);
        // 숫자 리스트를 계산하여 합계를 계산
        BigInteger sum = calculator.calculateSum(numbers);
        // 합계를 문자열로 반환
        return sum.toString();
    }
}