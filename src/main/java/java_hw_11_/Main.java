package java_hw_11_;

import java_hw_11_.enums.CoffeeSize;
import java_hw_11_.enums.DessertName;
import java_hw_11_.enums.OrderStatus;
import java_hw_11_.enums.TeaType;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Order latte = new CoffeeOrder(CoffeeSize.LARGE);
        Order greenTea = new TeaOrder(TeaType.GREEN);
        Order cake = new DessertOrder(DessertName.CAKE);
        Order cake2 = new DessertOrder(DessertName.PANCAKE);
        Order cake3 = new DessertOrder(DessertName.CANDIES);
        OrderManager totalBill = new OrderManager(new ArrayList<>());

        cake3.setOrderNumber((long) cake2.getOrderNumber());

        totalBill.addOrder(latte);
        totalBill.addOrder(greenTea);
        totalBill.addOrder(cake);
        totalBill.addOrder(cake2);
        totalBill.addOrder(cake3);
        totalBill.removeOrderByNumber(123);
        totalBill.findOrderByNumber(123);
        cake.setStatus(OrderStatus.CANCELED);

        latte.printOrderInfo();
        greenTea.printOrderInfo();
        cake.printOrderInfo();
        cake2.printOrderInfo();


        System.out.println(totalBill.getOrderTypeCounts());

        System.out.println("Total bill for all orders: UAH "+totalBill.calculateTotal());



    }
}
