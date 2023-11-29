package christmas.view;

import christmas.model.Order;
import christmas.util.Preview;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private static final int EVENT_MONTH = 12;
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String BEFORE_DISCOUNT_AMOUNT = "<할인 전 총주문 금액>\n%s원\n\n";
    private static final String PRESENT_MENU = "<증정 메뉴>";
    private static final String PRESENT_TRUE = "샴페인 1개";
    private static final String DOES_NOT_EXIST = "없음";
    private static final String BENEFIT_DETAILS = "<혜택내역>";
    private static final int CHAMPAGNE_PRICE = 25000;
    private static final String TOTAL_BENEFIT = "<총혜택 금액>";
    private static final String FINAL_PAYMENT = "<할인 후 예상 결제 금액>";
    private static final String BADGE = "<%d월 이벤트 배지>";

    public void preview(int date) {
        System.out.printf(Preview.START.getMessage(), EVENT_MONTH, date);
        lineBlank();
    }

    public void orderMenu(List<Order> orders) {
        System.out.print(Preview.ORDER_MENU.getMessage());
        for (Order order : orders) {
            System.out.print("\n" + order.toString());
        }
        lineBlank();
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
        System.out.println();
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
            System.out.println(DOES_NOT_EXIST);
        }
        System.out.println();
    }

    public void totalBenefit(int totalBenefit) {
        System.out.println(TOTAL_BENEFIT);
        if (totalBenefit==0) {
            System.out.printf("%s원\n\n", decimalFormat.format(totalBenefit));
        }
        if (totalBenefit!=0) {
            System.out.printf("-%s원\n\n", decimalFormat.format(totalBenefit));
        }
    }

    public void eventPayment(int eventPayment) {
        System.out.println(FINAL_PAYMENT);
        System.out.printf("%s원\n\n", decimalFormat.format(eventPayment));
    }

    public void giveBadge(String badge) {
        System.out.printf(BADGE, EVENT_MONTH);
        System.out.print(badge);
    }

    private void lineBlank() {
        System.out.print("\n\n");
    }
}
