package java_hw_11_;


import java_hw_11_.own_exceptions.DuplicateOrderException;
import java_hw_11_.own_exceptions.NoOrdersException;
import java_hw_11_.own_exceptions.OrderNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        try{
            if(this.orders.isEmpty()){
                throw new NoOrdersException("No orders in the bill!");
            }
            for (int i = 0; i < this.orders.size(); i++) {
                if (this.orders.get(i).getStatus() == OrderStatus.NEW) {
                    sumOfPrices += this.orders.get(i).getPrice();
                }
            }
            return sumOfPrices;
        }catch (NoOrdersException ex){
            ex.printStackTrace();
            return 0;
        }



    }

    public String eachOrderId() {
        String orderId = "";
        for (int i = 0; i < this.orders.size(); i++) {
            orderId += "Order " + (i + 1) + ": " + this.orders.get(i).getOrderNumber() + "\n";
        }
        return orderId;
    }

    public void addOrder(Order order) {
        try {
            for (Order existOrder : this.orders) {
                if (existOrder.getOrderNumber() == order.getOrderNumber()) {
                    throw new DuplicateOrderException("Order with this number is exist");
                }

            }
            this.orders.add(order);
        } catch (DuplicateOrderException ex) {
            ex.printStackTrace();
        }

    }

    public void removeOrderByNumber(double orderNumber) {
        boolean removeFlag = false;
        try {

            for (int i = 0; i < this.orders.size(); i++) {
                if (this.orders.get(i).getOrderNumber() == orderNumber) {
                    System.out.println(this.orders.get(i).toString() + " - deleted");
                    this.orders.remove(i);
                    removeFlag = true;
                    break;
                }
            }
            if (!removeFlag) {
                throw new OrderNotFoundException("Order with this number is not exist");
            }

        } catch (OrderNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Order findOrderByNumber(double orderNumber) {
        try {
            for (int i = 0; i < this.orders.size(); i++) {
                if (this.orders.get(i).getOrderNumber() == orderNumber) {
                    return this.orders.get(i);
                }
            }
            throw new OrderNotFoundException("Order with this number is not exist!");
        }catch(OrderNotFoundException ex){
        ex.printStackTrace();
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

public Map<String, Integer> getOrderTypeCounts() {
    Map<String, Integer> separetedSortedAmountOfOrders = new HashMap<>();
    separetedSortedAmountOfOrders.put("Tea", 0);
    separetedSortedAmountOfOrders.put("Coffee", 0);
    separetedSortedAmountOfOrders.put("Dessert", 0);
    for (Order order : this.orders) {
        if (order instanceof TeaOrder) {

            separetedSortedAmountOfOrders.replace("Tea", separetedSortedAmountOfOrders.get("Tea") + 1);

        } else if (order instanceof CoffeeOrder) {

            separetedSortedAmountOfOrders.replace("Coffee", separetedSortedAmountOfOrders.get("Coffee") + 1);

        } else if (order instanceof DessertOrder) {

            separetedSortedAmountOfOrders.replace("Dessert", separetedSortedAmountOfOrders.get("Dessert") + 1);

        } else {
            System.out.println("Unknown order");
        }
    }
    return separetedSortedAmountOfOrders;
}

@Override
public String toString() {
    return "OrderManager{" +
            "orders=" + orders +
            '}';
}
}
