package java_hw_8;


import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public OrderManager(List<Order> orders) {
        this.orders = orders;
    }

    public double calculateTotal() {
        double sumOfPrices = 0;
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getStatus().equals("NEW")) {
                sumOfPrices += this.orders.get(i).getPrice();
            }
        }
        return sumOfPrices;
    }

    public String eachOrderId() {
        String orderId = "";
        for (int i = 0; i < this.orders.size(); i++) {
            orderId += "Order " + (i + 1) + ": " + this.orders.get(i).getOrderNumber() + "\n";
        }
        return orderId;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void removeOrderByNumber(double orderNumber) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getOrderNumber() == orderNumber) {
                System.out.println(this.orders.get(i).toString()+" - deleted");
                this.orders.remove(i);
                break;
            }
        }
    }

    public Order findOrderByNumber(double orderNumber) {
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getOrderNumber() == orderNumber) {
                return this.orders.get(i);
            }
        }
        return null;
    }

    public List<Order> getOrdersByStatus(String status) {
        List<Order> orderWithStatus = new ArrayList<>();
        for (int i = 0; i < this.orders.size(); i++) {
            if (this.orders.get(i).getStatus().equals(status)) {
                orderWithStatus.add(this.orders.get(i));
            }
        }
        return orderWithStatus;
    }

    @Override
    public String toString() {
        return "OrderManager{" +
                "orders=" + orders +
                '}';
    }
}
