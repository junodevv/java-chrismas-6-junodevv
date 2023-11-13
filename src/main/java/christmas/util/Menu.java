package christmas.util;

public enum Menu {
    YANGSONG_SOUP("appetizer", "양송이수프", 6000),
    TAPAS("appetizer", "타바스", 5500),
    CAESAR_SALAD("appetizer", "시저샐러드", 8000),

    T_BONE_STEAK("main", "티본스테이크", 55000),
    BBQ_RIB("main", "바비큐립", 54000),
    SEAFOOD_PASTA("main", "해산물스타", 35000),
    CHRISTMAS_PASTA("main", "크리스마스파스타", 25000),

    CHOCO_CAKE("dessert", "초코케이크", 15000),
    ICE_CREAM("dessert", "아이스크림", 5000),

    ZERO_COLA("drink", "제로콜라", 3000),
    RED_WINE("drink", "레드와인", 60000),
    CHAMPAGNE("drink", "샴페인", 25000);

    private String type;
    private String name;
    private int price;

    Menu(String type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
