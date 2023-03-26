public class StockOrder implements Comparable<StockOrder> {
    private int numberOfShares;
    private double priceOfShares;
    private String orderType;

    public StockOrder(int numberOfShares, double priceOfShares, String orderType) {
        this.numberOfShares = numberOfShares;
        this.priceOfShares = priceOfShares;
        this.orderType = orderType;
    }

    public double getPrice() { return priceOfShares; }
    public int getNumber() { return numberOfShares; }
    public String getOrderType() { return orderType; }

    @Override
    public int compareTo(StockOrder otherOrder) {
        int value = 0;
        // For buying, higher priority is higher price
        if (this.getOrderType().equalsIgnoreCase("buy")) {
            double theResult = this.getPrice() - otherOrder.getPrice();
            if (theResult <= 0) {
                value = -1;
            } else {
                value = 1;
            }
        }
        // For selling, higher priority is lower price
        else if (this.getOrderType().equalsIgnoreCase("sell")) {
            double theResult = this.getPrice() - otherOrder.getPrice();
            if (theResult <= 0) {
                value = 1;
            } else {
                value = -1;
            }
        }
        return value;
    }
}
