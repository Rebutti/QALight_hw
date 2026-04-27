package java_hw_10;

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


    public long getOrderNumber() {
        return this.orderNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setStatus(String status) {
        try {
            if (!(status.equals("NEW") || status.equals("COMPLETED") || status.equals("CANCELED"))) {
                throw new InvalidOrderStatusException("Invalid order`s status!");
            }
            this.status = status;
        }catch (InvalidOrderStatusException ex){
            ex.printStackTrace();
        }

    }


    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                '}';
    }
}
