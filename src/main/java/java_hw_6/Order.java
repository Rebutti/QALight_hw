package java_hw_6;
import java.util.Random;

public abstract class Order {
    private final long orderNumber;
    Random random = new Random();

    public Order() {
        this.orderNumber = Math.abs(random.nextLong());;
    }

    public double getOrderNumber() {
        return orderNumber;
    }

    public abstract double getPrice();

    public void printOrderInfo(){
        System.out.println(this.orderNumber);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                '}';
    }
}
