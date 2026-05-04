package java_hw_10;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Order latte = new CoffeeOrder("LARGE");
        Order greenTea = new TeaOrder("green");
        Order cake = new DessertOrder("cake");
        Order cake2 = new DessertOrder("pancake");
        Order cake3 = new DessertOrder("candies");
        OrderManager totalBill = new OrderManager(new ArrayList<>());

        System.out.println(totalBill.calculateTotal());

        cake3.setOrderNumber((long) cake2.getOrderNumber());

        totalBill.addOrder(latte);
        totalBill.addOrder(greenTea);
        totalBill.addOrder(cake);
        totalBill.addOrder(cake2);
        totalBill.addOrder(cake3);
        totalBill.removeOrderByNumber(123);
        totalBill.findOrderByNumber(123);
        cake.setStatus("CANCELED2");

        latte.printOrderInfo();
        greenTea.printOrderInfo();
        cake.printOrderInfo();
        cake2.printOrderInfo();


        System.out.println(totalBill.getOrderTypeCounts());

        System.out.println(totalBill.calculateTotal());



    }
}
