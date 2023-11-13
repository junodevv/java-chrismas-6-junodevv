package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    @DisplayName("받은 주문을 데이터화 하는 기능 테스트")
    @Test
    void check() {
        String menu = "티본스테이크-1,바비큐립-1";
        Order order = new Order();

        List<Order> actual = order.check(menu);
        List<Order> expected = new ArrayList<>();
        Order tBone = new Order("티본스테이크", 1);
        Order bbqLib = new Order("바비큐립", 1);
        expected.add(tBone);
        expected.add(bbqLib);

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}
