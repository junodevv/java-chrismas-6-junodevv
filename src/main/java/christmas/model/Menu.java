package christmas.model;

import christmas.util.MenuData;
import java.util.HashMap;

public class Menu {
    private HashMap<String, Integer> priceData;
    private HashMap<String, String> typeData;

    public Menu() {
        makeTypeData();
        makePriceData();
    }

    public HashMap<String, Integer> getPriceData() {
        return priceData;
    }

    public HashMap<String, String> getTypeData() {
        return typeData;
    }

    private HashMap<String, Integer> makePriceData() {
        priceData = new HashMap<>();
        for (MenuData menuData : MenuData.values()) {
            priceData.put(menuData.getName(), menuData.getPrice());
        }
        return priceData;
    }

    private HashMap<String, String> makeTypeData() {
        typeData = new HashMap<>();
        for (MenuData menuData : MenuData.values()) {
            typeData.put(menuData.getName(), menuData.getType());
        }
        return typeData;
    }
}
