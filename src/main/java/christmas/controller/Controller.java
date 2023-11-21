package christmas.controller;

import christmas.model.Event;
import christmas.model.Menu;
import christmas.model.Order;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        try {
            // 입력받기
            inputView.Greeting();
            inputView.askDate();
            int date = inputView.readDate();
            inputView.askMenu();
            String totalOrder = inputView.readMenu();

            // 주문
            Order order = new Order();
            Menu menu = new Menu();

            List<Order> orders = order.check(totalOrder);
            int dessertCount = order.findDessert(orders, menu.getTypeData());
            int mainCount = order.findMain(orders, menu.getTypeData());
            int totalAmount = order.totalAmount(orders, menu.getPriceData());
            order.checkMenu(orders, menu.getTypeData());
            order.maxCount(orders);

            Event event = new Event();
            boolean present = event.present(totalAmount);
            boolean eventCondition = event.checkCondition(totalAmount);
            int totalBenefit = event.totalBenefit(eventCondition, date, dessertCount, mainCount, totalAmount);
            int eventPayment = event.finalPayment(totalAmount, totalBenefit, present);
            String badge = event.checkBadge(totalBenefit);
            //출력
            outputView.preview(date);
            outputView.orderMenu(orders);
            outputView.beforeDiscountAmount(totalAmount);
            outputView.presentMenu(present);
            outputView.benefitDetails(
                    eventCondition,
                    event.christmasDDay(date),
                    event.weekday(dessertCount, date),
                    event.weekend(mainCount, date),
                    event.starDay(date),
                    event.present(totalAmount)
            );
            outputView.totalBenefit(totalBenefit);
            outputView.eventPayment(eventPayment);
            outputView.giveBadge(badge);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
