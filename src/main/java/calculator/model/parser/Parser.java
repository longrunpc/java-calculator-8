package calculator.model.parser;

import java.math.BigInteger;
import java.util.List;

/**
 * 파싱 인터페이스
 */
public interface Parser {
    /**
     * 문자열을 입력받아 숫자 리스트로 파싱하는 메서드
     *
     * @param input
     * @return
     */
    List<BigInteger> parseNumbers(String input);
}