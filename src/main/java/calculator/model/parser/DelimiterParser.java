package calculator.model.parser;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import calculator.common.ErrorMessages;

/**
 * 문자열 구분자로 숫자 리스트를 파싱하는 클래스
 */
public class DelimiterParser implements Parser {

    // 기본 구분자 리스트
    private static final List<String> DEFAULT_DELIMITERS = List.of(",", ":");
    // 커스텀 구분자 패턴
    private static final Pattern CUSTOM_DELIMITER_PREFIX = Pattern.compile("//(.)\\\\n(.*)");

    // 파싱 결과 레코드
    private record ParseResult(String delimiterRegex, String numberSection) {
    }

    @Override
    public List<BigInteger> parseNumbers(String input) {
        ParseResult parseResult = extractDelimiterRegex(input);
        try {
            return Arrays.stream(parseResult.numberSection.split(parseResult.delimiterRegex))
                    .filter(s -> !s.isEmpty())
                    .map(BigInteger::new)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_FORMAT, e);
        }
    }

    /**
     * 구분자와 숫자 부분을 추출하는 메서드
     * 
     * @param input
     * @return
     */
    private ParseResult extractDelimiterRegex(String input) {
        Matcher matcher = findCustomDelimiter(input);
        List<String> delimiters = new ArrayList<>(DEFAULT_DELIMITERS);
        String numberSection = input;
        // 커스텀 구분자가 있는 경우
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            delimiters.add(customDelimiter);
            numberSection = matcher.group(2);
        }

        // 모든 구분자를 정규식 패턴으로 결합
        return new ParseResult(toDelimiterRegex(delimiters), numberSection);
    }

    /**
     * 커스텀 구분자를 찾는 메서드
     * 
     * @param input
     * @return
     */
    private Matcher findCustomDelimiter(String input) {
        return CUSTOM_DELIMITER_PREFIX.matcher(input);
    }

    /**
     * 구분자를 정규식 패턴으로 변환하는 메서드
     * 
     * @param delimiters
     * @return
     */
    private String toDelimiterRegex(List<String> delimiters) {
        return delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
