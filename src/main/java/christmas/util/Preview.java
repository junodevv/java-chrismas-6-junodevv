package christmas.util;

public enum Preview {
    START("%d월%d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER_MENU("<주문 메뉴>"),
    BEFORE_DISCOUNT_AMOUNT("<할인 전 총주문 금액>"),
    PRESENT_MENU("<증정 메뉴>"),
    BENEFIT_DETAILS("<혜택 내역>"),
    TOTAL_BENEFIT("<총혜택 금액>"),
    FINAL_PAYMENT("<할인 후 예상 결제 금액>");

    private String message;

    Preview(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
