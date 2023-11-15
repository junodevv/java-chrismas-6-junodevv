package christmas.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Event {
    private static final int EVENT_AMOUNT_CONDITION = 10000;
    private static final int CHRISTMAS_DAY = 25;
    private static final int CHRISTMAS_DEFAULT_DISCOUNT = 1000;
    private static final int CHRISTMAS_ADDITIONAL_DISCOUNT = 100;
    private static final List<Integer> WEEKEND = new ArrayList<>(
            Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
    );
    private static final int WEEK_DISCOUNT = 2023;
    private static final List<Integer> STAR_DAY = new ArrayList<>(
            Arrays.asList(3, 10, 17, 24, 25, 31)
    );
    private static final int STAR_DAY_DISCOUNT = 1000;
    private static final int PRESENT_CONDITION_AMOUNT = 120000;

    public boolean checkCondition(int totalAmount, boolean checkMenu) {
        if (totalAmount > EVENT_AMOUNT_CONDITION && checkMenu) {
            return true;
        }
        return false;
    }

    public int christmasDDay(int date) {
        if (date <= CHRISTMAS_DAY) {
            return CHRISTMAS_DEFAULT_DISCOUNT + ((date - 1) * CHRISTMAS_ADDITIONAL_DISCOUNT);
        }
        return 0;
    }

    public int weekday(int dessertCount, int date) {
        if (!(WEEKEND.contains(date))) {
            return dessertCount * WEEK_DISCOUNT;
        }
        return 0;
    }

    public int weekend(int mainCount, int date) {
        if (WEEKEND.contains(date)) {
            return mainCount * WEEK_DISCOUNT;
        }
        return 0;
    }

    public int starDay(int date) {
        if (STAR_DAY.contains(date)) {
            return STAR_DAY_DISCOUNT;
        }
        return 0;
    }

    public boolean present(int totalAmount) {
        if (totalAmount >= PRESENT_CONDITION_AMOUNT) {
            return true;
        }
        return false;
    }
}
