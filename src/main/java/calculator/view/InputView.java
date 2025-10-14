package calculator.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자 입력 관련 View 클래스
 */
public class InputView {
    /**
     * 사용자로 부터 문자열을 입력받는 메서드
     * @return 사용자로 부터 입력받은 문자열
     */
    public static String readInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
}