package java_hw_9;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Order latte = new CoffeeOrder("LARGE");
        Order greenTea = new TeaOrder("green");
        Order cake = new DessertOrder("cake");
        Order cake2 = new DessertOrder("pancake");
        OrderManager totalBill = new OrderManager(new ArrayList<>());

        totalBill.addOrder(latte);
        totalBill.addOrder(greenTea);
        totalBill.addOrder(cake);
        totalBill.addOrder(cake2);

        latte.printOrderInfo();
        greenTea.printOrderInfo();
        cake.printOrderInfo();
        cake2.printOrderInfo();

        System.out.println(totalBill.getOrderTypeCounts());


//        ConsoleManager consoleManager = new ConsoleManager();
//
//
//        System.out.println(consoleManager.billGetter());

    }
}
