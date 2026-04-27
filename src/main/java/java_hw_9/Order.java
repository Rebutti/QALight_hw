package java_hw_9;

import java.util.Random;

public abstract class Order implements Pricable, Printable {
    private long orderNumber;
    private String status;
    Random random = new Random();

//    public Order() {
//        this.orderNumber = Math.abs(random.nextLong());
//    }

    public Order() {
        this.orderNumber = Math.abs(random.nextLong());
        this.status = "NEW";
    }

    public double getOrderNumber() {
        return this.orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //    public abstract double getPrice();

//    public void printOrderInfo(){
//        System.out.println(this.orderNumber);
//    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                '}';
    }
}
