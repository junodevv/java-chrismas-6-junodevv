package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final int EVENT_MONTH = 12;
    private static final String GREETING = "안녕하세요! 우테코 식당" + EVENT_MONTH + "월 이벤트 플레너 입니다.";
    private static final String ASK_VISIT_DATE = EVENT_MONTH + "월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    public void Greeting() {
        System.out.println(GREETING);
    }

    public void askDate() {
        System.out.println(ASK_VISIT_DATE);
    }

    public int readDate() {
        String date = readLine();
        return Integer.parseInt(date);
    }
}
