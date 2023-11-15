package christmas.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Event {
    private static final int CHRISTMAS_DAY = 25;
    private static final int CHRISTMAS_DEFAULT_DISCOUNT = 1000;
    private static final List<Integer> WEEKEND = new ArrayList<>(
            Arrays.asList(1, 2, 8, 9, 15, 16, 22, 23, 29, 30)
    );
    private static final int WEEK_DISCOUNT = 2023;
    private static final List<Integer> STAR_DAY = new ArrayList<>(
            Arrays.asList(3, 10, 17, 24, 25, 31)
    );
    private static final int STAR_DAY_DISCOUNT = 1000;

    public int christmasDDay(int date) {
        if (date <= CHRISTMAS_DAY) {
            return CHRISTMAS_DEFAULT_DISCOUNT + ((date - 1) * 100);
        }
        return 0;
    }

    public int weekday(int dessertCount) {
        return dessertCount * WEEK_DISCOUNT;
    }

    public int weekend(int mainCount) {
        return mainCount * WEEK_DISCOUNT;
    }

    public int starday() {
        return STAR_DAY_DISCOUNT;
    }

}
