import java.util.PriorityQueue;
import java.util.Scanner;

public class StockBuyAndSell {
    /** Write a program that can process a sequence of stock buy and sell orders:
     * An online computer system for trading stocks needs to process orders of the form
     * “buy 100 shares at $x each” or “sell 100 shares at $y each.” A buy order for $x
     * can only be processed if there is an existing sell order with price $y such that
     * y ≤ x. Likewise, a sell order for $y can only be processed if there is an existing
     * buy order with price $x such that y ≤ x. If a buy or sell order is entered but
     * cannot be processed, it must wait for a future order that allows it to be processed.
     * Describe a scheme that allows buy and sell orders to be entered in O(logn) time,
     * independent of whether or not they can be immediately processed.
     * */

    public static void main(String[] args) {

        /** Since the number of stock is not considered important in the example,
        * it is not implemented fully here, only the price.
        * However, if there is not enough stock to cover a transaction,
        * the transaction is denied and added to the list. */

        PriorityQueue<StockOrder> buyList = new PriorityQueue<>();
        PriorityQueue<StockOrder> sellList = new PriorityQueue<>();
        String input = "";
        StockOrder newOrder = null;

        Scanner scan = new Scanner(System.in);

        System.out.println("Do you want to buy, sell, or exit?");
        input = scan.nextLine();

        while(!input.equalsIgnoreCase("exit")) {
            if(input.equalsIgnoreCase("buy")){
                System.out.println("How many do you want to buy?");
                String numberString = scan.nextLine();
                int number = Integer.parseInt(numberString);
                System.out.println("How much do you want to buy them for? E.g., 25.45");
                String priceString = scan.nextLine();
                double price = Double.parseDouble(priceString);
                newOrder = new StockOrder(number, price, "buy");
                placeOrder(newOrder, buyList, sellList);
            }
            else if (input.equalsIgnoreCase("sell")) {
                System.out.println("How many do you want to sell?");
                String numberString = scan.nextLine();
                int number = Integer.parseInt(numberString);
                System.out.println("How much do you want to sell them for? E.g., 25.45");
                String priceString = scan.nextLine();
                double price = Double.parseDouble(priceString);
                newOrder = new StockOrder(number, price, "sell");
                placeOrder(newOrder, buyList, sellList);
            }
            else {
                System.out.println("That is not a valid option.");
            }
            System.out.println("Do you want to buy, sell, or exit?");
            input = scan.nextLine();
        }
    }

    public static boolean placeOrder(StockOrder order, PriorityQueue<StockOrder> buyList, PriorityQueue<StockOrder> sellList){
        String type = order.getOrderType();
        boolean success = false;
        if (type.equals("buy")){
            if (sellList.size() > 0) {
                success = buyOrderProcess(order, sellList.peek(), buyList, sellList);
            } else {
                buyList.add(order);
                System.out.println("Your request has been added to the list.");
            }
        }
        else if (type.equalsIgnoreCase("sell")) {
            if (buyList.size() > 0) {
                success = sellOrderProcess(buyList.peek(), order, buyList, sellList);
            } else {
                sellList.add(order);
                System.out.println("Your request has been added to the list.");
            }
        }
        return success;
    }

    public static boolean buyOrderProcess(StockOrder buyOrder, StockOrder sellLowest, PriorityQueue<StockOrder> buyList, PriorityQueue<StockOrder> sellList) {
        boolean success = false;
        double buyPrice = buyOrder.getPrice();
        int buyNumber = buyOrder.getNumber();
        if (sellList!=null) {
            double sellPrice = sellLowest.getPrice();
            int sellNumber = sellLowest.getNumber();
            if (buyPrice >= sellPrice && buyNumber <= sellNumber) {
                System.out.println("Successful buy: " + buyPrice + " vs. sell price " + sellPrice);
                success = true;
                sellList.remove();
            } else {
                buyList.add(buyOrder);
                System.out.println("Your request has been added to the list.");
            }
        }
        return success;
    }

    public static boolean sellOrderProcess(StockOrder buyOrder, StockOrder sellOrder, PriorityQueue<StockOrder> buyList, PriorityQueue<StockOrder> sellList) {
        boolean success = false;
        double sellPrice = sellOrder.getPrice();
        int sellNumber = sellOrder.getNumber();
        if (sellList!=null) {
            double buyPrice = buyOrder.getPrice();
            int buyNumber = buyOrder.getNumber();
            if (buyPrice >= sellPrice && buyNumber <= sellNumber) {
                    System.out.println("Successful sell: " + sellPrice + " vs. buy price " + buyPrice);
                    success = true;
                    buyList.remove();
            } else {
                sellList.add(sellOrder);
                System.out.println("Your request has been added to the list.");
            }
        }
        return success;
    }
}
