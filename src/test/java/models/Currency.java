package models;

public enum Currency {
    RUB("₽"),
    BYN("р"),
    KZT("тг");
    private String symbol;
    Currency(String symbol) {
        this.symbol = symbol;
    }
    public String getSymbol() {
        return symbol;
    }
}