package christmas.util;

public enum ExceptionMessage {
    ERROR("[ERROR]"),
    DATE(" 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER(" 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_DRINK(" 음료만 주문시 주문불가 합니다."),
    ORDER_COUNT_MAX(" 메뉴는 한번에 20개 까지만 주문 가능합니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR.message + message;
    }
}
