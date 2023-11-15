package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderTest {
    @DisplayName("받은 주문을 데이터화 하는 기능 테스트")
    @Test
    void check() {
        String menuExample = "티본스테이크-1,바비큐립-1";
        Order order = new Order();

        List<Order> actual = order.check(menuExample);
        List<Order> expected = new ArrayList<>();
        Order tBone = new Order("티본스테이크", 1);
        Order bbqLib = new Order("바비큐립", 1);
        expected.add(tBone);
        expected.add(bbqLib);

        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @DisplayName("주문중에서 디저트의 갯수를 찾는 기능 테스트")
    @Test
    void findDessert_테스트() {
        String menuExample = "티본스테이크-1,바비큐립-1,초코케이크-2,아이스크림-1";
        Order order = new Order();
        Menu menu = new Menu();

        List<Order> orders = order.check(menuExample);
        HashMap<String, String> typeData = menu.getTypeData();
        int actual = order.findDessert(orders, typeData);
        int expected = 3;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("주문중에서 메인메뉴의 갯수를 찾는 기능 테스트")
    @Test
    void findMain_테스트() {
        String menuExample = "티본스테이크-1,바비큐립-1,초코케이크-2,아이스크림-1";
        Order order = new Order();
        Menu menu = new Menu();

        List<Order> orders = order.check(menuExample);
        HashMap<String, String> typeData = menu.getTypeData();
        int actual = order.findMain(orders, typeData);
        int expected = 2;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("총 주문 금액을 구하는 기능 테스트")
    @Test
    void totalAmount_테스트() {
        String menuExample = "티본스테이크-1,바비큐립-1,초코케이크-2,아이스크림-1";
        Order order = new Order();
        Menu menu = new Menu();

        List<Order> orders = order.check(menuExample);
        HashMap<String, Integer> priceData = menu.getPriceData();
        int actual = order.totalAmount(orders, priceData);
        int expected = 144000;

        assertThat(actual).isEqualTo(expected);
    }
}
