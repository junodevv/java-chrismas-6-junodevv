package christmas.model;

import christmas.util.MenuData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
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
            String menu = menuAndCount.substring(0, menuAndCount.length() - 2);
            int count = Integer.parseInt(
                    menuAndCount.substring(menuAndCount.length() - 1)
            );
            Order newOrder = new Order(menu, count);
            orders.add(newOrder);
        }
        return orders;
    }

    private void validateMenu(String menu) {
        if (MenuData.valueOf(menu)==null) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateCount(int count) {
        if (count==0) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
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
