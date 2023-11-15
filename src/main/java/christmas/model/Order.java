package christmas.model;

import christmas.util.MenuData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
    private static final String ORDER_EXCEPTION_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    private String menu;
    private int count;

    public Order() {
    }

    public Order(String menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    public List<Order> check(String totalOrder) {
        List<Order> orders = new ArrayList<>();
        String[] eachOrder = totalOrder.split(",");
        for (String menuAndCount : eachOrder) {
            validateFormat(menuAndCount);
            String menu = menuAndCount.substring(0, menuAndCount.length() - 2);
            int count = Integer.parseInt(
                    menuAndCount.substring(menuAndCount.length() - 1)
            );
            validateMenuAndCount(menu, count);
            Order newOrder = new Order(menu, count);
            orders.add(newOrder);
        }
        return orders;
    }

    private void validateMenuAndCount(String menu, int count) {
        if (MenuData.valueOf(menu)==null || count==0) {
            throw new IllegalArgumentException(ORDER_EXCEPTION_MESSAGE);
        }
    }

    private void validateFormat(String menuAndCount) {
        String pattern = "^[가-힣]+-\\d+$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(menuAndCount);
        if (!(matcher.matches())) {
            throw new IllegalArgumentException(ORDER_EXCEPTION_MESSAGE);
        }
    }

    public int findDessert(List<Order> orders, HashMap<String, String> typeData) {
        int dessertCount = 0;
        for (Order order : orders) {
            if (typeData.get(order.menu).equals("dessert")) {
                dessertCount = dessertCount + order.count;
            }
        }
        return dessertCount;
    }

    public int findMain(List<Order> orders, HashMap<String, String> typeData) {
        int mainCount = 0;
        for (Order order : orders) {
            if (typeData.get(order.menu).equals("main")) {
                mainCount = mainCount + order.count;
            }
        }
        return mainCount;
    }

    public int totalAmount(List<Order> orders, HashMap<String, Integer> priceData) {
        int totalAmount = 0;
        for (Order order : orders) {
            int eachPrice = priceData.get(order.menu);
            int count = order.count;
            totalAmount = totalAmount + (eachPrice * count);
        }
        return totalAmount;
    }

    public boolean checkMenu(List<Order> orders, HashMap<String, String> typeData) {
        boolean checkMenu = false;
        for (Order order : orders) {
            if (!(typeData.get(order.menu).equals("drink"))) {
                checkMenu = true;
            }
        }
        return checkMenu;
    }

    @Override
    public String toString() {
        return menu + " " + count + "개";
    }
}
