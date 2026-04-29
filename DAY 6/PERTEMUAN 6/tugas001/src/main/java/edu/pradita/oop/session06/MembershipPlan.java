package edu.pradita.oop.session06;

public enum MembershipPlan {

    THREE_MONTHS(3, 300_000),
    SIX_MONTHS(6, 550_000),
    NINE_MONTHS(9, 750_000);

    private final int months;
    private final int priceIdr;

    MembershipPlan(int months, int priceIdr) {
        this.months = months;
        this.priceIdr = priceIdr;
    }

    public int getMonths() {
        return months;
    }

    public int getPriceIdr() {
        return priceIdr;
    }
}
