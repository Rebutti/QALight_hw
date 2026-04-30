package java_hw_11_;

import java_hw_11_.own_exceptions.InvalidOrderStatusException;
import java.util.Random;

public abstract class Order implements Pricable, Printable {
    private long orderNumber;
    private OrderStatus status;
    Random random = new Random();

    public Order() {
        this.orderNumber = Math.abs(random.nextLong());
        this.status = OrderStatus.NEW;
    }


    public long getOrderNumber() {
        return this.orderNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setStatus(OrderStatus status) {
        try {
            if (!(status == OrderStatus.NEW || status == OrderStatus.CANCELED || status == OrderStatus.COMPLETED)) {
                throw new InvalidOrderStatusException("Invalid order`s status!");
            }
            this.status = status;
        }catch (InvalidOrderStatusException ex){
            ex.printStackTrace();
        }
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                '}';
    }
}
