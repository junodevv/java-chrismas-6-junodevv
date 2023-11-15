package christmas.view;

import christmas.model.Order;
import java.util.List;

public class OutputView {
    private static final int EVENT_MONTH = 12;
    private static final String PREVIEW = EVENT_MONTH + "%d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU = "<주문 메뉴>";

    public void preview(int date) {
        System.out.printf(PREVIEW, date);
    }

    public void orderMenu(List<Order> orders) {
        System.out.println(ORDER_MENU);
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }
}