package christmas.view;

import static org.junit.jupiter.api.Assertions.*;

import christmas.model.Order;
import christmas.util.Preview;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {
    private OutputView outputView;
    private ByteArrayOutputStream outContent;
    private static final int EVENT_MONTH = 12;

    @BeforeEach
    void setup() {
        outputView = new OutputView();
        // 콘솔 출력을 캡처하기 위한 ByteArrayOutputStream 사용
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("preview 메서드 출력 테스트")
    @Test
    void preview_테스트() {
        int date = 3;

        outputView.preview(date);

        String expectedOutput = String.format(Preview.START.getMessage(), EVENT_MONTH, date) + "\n\n";
        String actualOutput = outContent.toString();

        // 기대한 출력과 실제 출력 비교
        assertEquals(expectedOutput, actualOutput);

        // 테스트 이후 System.out을 원래 상태로 되돌리기
        System.setOut(System.out);

    }

    @DisplayName("orderMenu 메서드 출력 테스트")
    @Test
    void orderMenu_테스트() {
        List<Order> orders = new ArrayList<>();
        Order order = new Order("타파스", 1);
        Order order2 = new Order("제로콜라", 1);
        orders.add(order);
        orders.add(order2);

        outputView.orderMenu(orders);

        String expectedOutput = Preview.ORDER_MENU.getMessage() + "\n타파스 1개\n제로콜라 1개\n\n";
        String actualOutput = outContent.toString();

        assertEquals(actualOutput, expectedOutput);

        System.setOut(System.out);
    }

    @DisplayName("beforeDiscountAmount 메서드 출력 테스트")
    @Test
    void beforeDiscountAmount_테스트() {
        int totalAmount = 20000;

        outputView.beforeDiscountAmount(20000);

        String expectedOutput = Preview.BEFORE_DISCOUNT_AMOUNT.getMessage() + "\n" + "20,000원\n\n";
        String actualOutput = outContent.toString();

        assertEquals(actualOutput, expectedOutput);

        System.setOut(System.out);
    }
}