package christmas.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String menu;
    private int count;

    public List<Order> check(String menu) {
        List<Order> orders = new ArrayList<>();
        String[] menuAndCount = menu.split(",");
        for (String orderText : menuAndCount) {
            Order newOrder = new Order();
            newOrder.menu = orderText.substring(0, orderText.length() - 2);
            newOrder.count = Integer.parseInt(
                    orderText.substring(orderText.length() - 1)
            );
            orders.add(newOrder);
        }
        return orders;
    }

}
