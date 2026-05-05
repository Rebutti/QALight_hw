package java_hw_7;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleManager {

    Scanner sc = new Scanner(System.in);

    public String billGetter() {
        int meal;
        String coffeeSize = "SMALL";
        String teaType = "green";
        String dessert = "cake";
        int customerSize;
        ArrayList<Order> orders = new ArrayList<>();
        while (true) {
            System.out.println("Choose meal:\n1-coffee\n2-tea\n3-dessert\n4-quit");
            meal = sc.nextInt();
            switch (meal) {
                case 1:
                    System.out.println("Choose coffee size:\n1-SMALL (UAH 34)\n2-MEDIUM (UAH 39)\n3-LARGE (UAH 44)");
                    customerSize = sc.nextInt();
                    switch (customerSize) {
                        case 1:
                            coffeeSize = "SMALL";
                            orders.add(new CoffeeOrder(coffeeSize));
                            continue;
                        case 2:
                            coffeeSize = "MEDIUM";
                            orders.add(new CoffeeOrder(coffeeSize));
                            continue;
                        case 3:
                            coffeeSize = "LARGE";
                            orders.add(new CoffeeOrder(coffeeSize));
                            continue;
                    }
                case 2:
                    System.out.println("Choose tea type:\n1-green (UAH 35)\n2-black (UAH 37)\n3-herbal (UAH 40)");
                    customerSize = sc.nextInt();
                    switch (customerSize) {
                        case 1:
                            teaType = "green";
                            orders.add(new TeaOrder(teaType));
                            continue;
                        case 2:
                            teaType = "black";
                            orders.add(new TeaOrder(teaType));
                            continue;
                        case 3:
                            teaType = "herbal";
                            orders.add(new TeaOrder(teaType));
                            continue;
                    }
                case 3:
                    System.out.println("Choose dessert type:\n1-cake  (UAH 300)\n2-pancake (UAH 250)\n3-candies (UAH 51)");
                    customerSize = sc.nextInt();
                    switch (customerSize) {
                        case 1:
                            dessert = "cake";
                            orders.add(new DessertOrder(dessert));
                            continue;
                        case 2:
                            dessert = "pancake";
                            orders.add(new DessertOrder(dessert));
                            continue;
                        case 3:
                            dessert = "candies";
                            orders.add(new DessertOrder(dessert));
                            continue;
                    }

                case 4:
                    Order[] finalOrders = orders.toArray(new Order[0]);
                    OrderManager totalBill = new OrderManager();
                    return "Total bill for all orders: UAH " + totalBill.calculateTotal(finalOrders);
            }

        }

    }
}
