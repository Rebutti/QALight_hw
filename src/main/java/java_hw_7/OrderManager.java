package java_hw_7;

public class OrderManager {

    public double calculateTotal(Order[] orders) {
        double sumOfPrices = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getStatus().equals("NEW")) {
                sumOfPrices += orders[i].getPrice();
            }
        }
        return sumOfPrices;
    }

    public String eachOrderId(Order[] orders) {
        String orderId = "";
        for (int i = 0; i < orders.length; i++) {
            orderId += "Order " + (i + 1) + ": " + orders[i].getOrderNumber() + "\n";
        }
        return orderId;
    }
}
