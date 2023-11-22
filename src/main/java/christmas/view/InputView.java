package christmas.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.util.ExceptionMessage;

public class InputView {
    private static final int EVENT_MONTH = 12;
    private static final int FIRST_DATE = 1;
    private static final int LAST_DATE = 31;
    private static final String GREETING = "안녕하세요! 우테코 식당" + EVENT_MONTH + "월 이벤트 플레너 입니다.";
    private static final String ASK_VISIT_DATE = EVENT_MONTH + "월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";
    private static final String ASK_MENU = "주문하실 메뉴의 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";


    public void Greeting() {
        System.out.println(GREETING);
    }

    public void askDate() {
        System.out.println(ASK_VISIT_DATE);
    }

    public int readDate() {
        String dateText = readLine();
        try {
            int date = Integer.parseInt(dateText);
            validateDate(date);
            return date;
        } catch (Exception e) {
            throw new NumberFormatException(ExceptionMessage.DATE.getMessage());
        }
    }

    public void askMenu() {
        System.out.println(ASK_MENU);
    }

    public String readMenu() {
        String totalOrder = readLine();
        return totalOrder;
    }

    private void validateDate(int date) {
        if (date < FIRST_DATE || date > LAST_DATE) {
            throw new IllegalArgumentException(ExceptionMessage.DATE.getMessage());
        }
    }
}
