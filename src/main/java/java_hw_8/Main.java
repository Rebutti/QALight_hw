package java_hw_8;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Order latte = new CoffeeOrder("L");
        Order greenTea = new TeaOrder("green");
        Order cake = new DessertOrder("cake");
        OrderManager totalBill = new OrderManager(new ArrayList<>());

        totalBill.addOrder(latte);
        totalBill.addOrder(greenTea);
        totalBill.addOrder(cake);

        latte.printOrderInfo();
        greenTea.printOrderInfo();
        cake.printOrderInfo();

        cake.setStatus("CANCELED");




//        totalBill.removeOrderByNumber(latte.getOrderNumber());

        System.out.println("Your order by number - " + cake.getOrderNumber() + " is " + totalBill.findOrderByNumber(cake.getOrderNumber()));
        System.out.println(totalBill.findOrderByNumber(1));

        System.out.println("Orders with NEW status - " + totalBill.getOrdersByStatus("NEW"));
        System.out.println("Orders with CANCELED status - " + totalBill.getOrdersByStatus("CANCELED"));

        System.out.println("Total bill for all orders: UAH " + totalBill.calculateTotal());


//        ConsoleManager consoleManager = new ConsoleManager();
//
//
//        System.out.println(consoleManager.billGetter());

    }
}
