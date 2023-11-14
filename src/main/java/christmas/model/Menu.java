package christmas.model;

import christmas.util.MenuData;
import java.util.HashMap;

public class Menu {
    private HashMap<String, Integer> priceData;
    private HashMap<String, String> typeData;

    public HashMap<String, Integer> makePriceData() {
        HashMap<String, Integer> priceData = new HashMap<>();
        for (MenuData menuData : MenuData.values()) {
            priceData.put(menuData.getName(), menuData.getPrice());
        }
        return priceData;
    }
}
