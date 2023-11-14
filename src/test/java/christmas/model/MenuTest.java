package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import christmas.util.MenuData;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {
    @DisplayName("메뉴와 가격을 매핑하여 데이터화 하는 기능 테스트")
    @Test
    void makePriceData_테스트() {
        Menu menu = new Menu();
        MenuData[] menuDatas = MenuData.values();
        MenuData menuData0 = menuDatas[0];


        HashMap<String, Integer> priceData = menu.makePriceData();
        boolean actual = priceData.containsKey(menuData0.getName());
        boolean expected = true;

        assertThat(actual).isEqualTo(expected);
    }
}