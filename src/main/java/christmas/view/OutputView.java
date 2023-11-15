package christmas.view;

import christmas.model.Order;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private static final int EVENT_MONTH = 12;
    private static final String PREVIEW = EVENT_MONTH + "%d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String BEFORE_DISCOUNT_AMOUNT = "<할인 전 총주문 금액>\n%s원";
    private static final String PRESENT_MENU = "<증정 메뉴>";
    private static final String PRESENT_TRUE = "샴페인 1개";
    private static final String DOES_NOT_EXIST = "없음";
    private static final String BENEFIT_DETAILS = "<혜택내역>";
    private static final int CHAMPAGNE_PRICE = 25000;

    public void preview(int date) {
        System.out.printf(PREVIEW, date);
    }

    public void orderMenu(List<Order> orders) {
        System.out.println(ORDER_MENU);
        for (Order order : orders) {
            System.out.println(order.toString());
        }
    }

    public void beforeDiscountAmount(int totalAmount) {
        String totalAmountText = decimalFormat.format(totalAmount);
        System.out.printf(BEFORE_DISCOUNT_AMOUNT, totalAmountText);
    }

    public void presentMenu(boolean present) {
        System.out.println(PRESENT_MENU);
        if (present==true) {
            System.out.println(PRESENT_TRUE);
        }
        if (present==false) {
            System.out.println(DOES_NOT_EXIST);
        }
    }

    private void christmasDDayToString(int christmasBenefit) {
        if (christmasBenefit > 0) {
            System.out.printf("크리스마스 디데이 할인: -%s원\n", decimalFormat.format(christmasBenefit));
        }
    }

    private void weekdayToString(int weekdayBenefit) {
        if (weekdayBenefit > 0) {
            System.out.printf("평일 할인: -%s원\n", decimalFormat.format(weekdayBenefit));
        }
    }

    private void weekendToString(int weekendBenefit) {
        if (weekendBenefit > 0) {
            System.out.printf("주말 할인: -%s원\n", decimalFormat.format(weekendBenefit));
        }
    }

    private void starDayToString(int starDayBenefit) {
        if (starDayBenefit > 0) {
            System.out.printf("특별 할인: -%s원\n", decimalFormat.format(starDayBenefit));
        }
    }

    private void presentToString(boolean presentBenefit) {
        if (presentBenefit) {
            System.out.printf("증정 이벤트: -%s원\n", decimalFormat.format(CHAMPAGNE_PRICE));
        }
    }

    public void benefitDetails(
            boolean checkCondition, int christmasBenefit, int weekdayBenefit,
            int weekendBenefit, int starDayBenefit, boolean presentBenefit) {
        System.out.println(BENEFIT_DETAILS);
        if (checkCondition) {
            christmasDDayToString(christmasBenefit);
            weekdayToString(weekdayBenefit);
            weekendToString(weekendBenefit);
            starDayToString(starDayBenefit);
            presentToString(presentBenefit);
        }
        if (!checkCondition) {
            System.out.print(DOES_NOT_EXIST);
        }
    }

    public void totalBenefit() {

    }
}
