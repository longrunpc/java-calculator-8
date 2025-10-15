package calculator.model.calculator;

import java.math.BigInteger;
import java.util.List;

/**
 * 양수 값만 허용하는 계산기 클래스
 */
public class PositiveNumberCalculator implements Calculator {
    /**
     * 숫자 리스트를 입력받아 합계를 계산하는 메서드
     * @param numbers
     * @return
     */
    @Override
    public BigInteger calculateSum(List<BigInteger> numbers) {
        checkNegativeNumbers(numbers);
        return numbers.stream()
                .reduce(BigInteger.ZERO, BigInteger::add);
    }

    /**
     * 숫자 리스트를 입력받아 음수가 있는지 확인하는 메서드
     * @param numbers
     */
    private void checkNegativeNumbers(List<BigInteger> numbers) {
        if (numbers.stream().anyMatch(n -> n.compareTo(BigInteger.ZERO) < 0)) {
            throw new IllegalArgumentException("음수값이 포함되어 있습니다.");
        }
    }
}
