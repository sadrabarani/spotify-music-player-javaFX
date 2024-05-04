package model;

public enum SubscriptionPlan {
    OneMonth(5),TwoMonth(9),SixMonth(14);
    private final int price;
    SubscriptionPlan(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
