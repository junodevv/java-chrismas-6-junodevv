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

    public int christmasDDay(int date) {
        if (date <= CHRISTMAS_DAY) {
            return CHRISTMAS_DEFAULT_DISCOUNT + ((date - 1) * 100);
        }
        return 0;
    }

    public int weekday(int date) {

        return 0;
    }
}
