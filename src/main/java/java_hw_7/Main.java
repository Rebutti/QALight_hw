package java_hw_7;

public class Main {
    public static void main(String[] args) {
//        Order order = new Order(123);
        Order latte = new CoffeeOrder("LARGE");
//        System.out.println(latte.getPrice());
        Order greenTea = new TeaOrder("green");
//        System.out.println(greenTea.getOrderNumber() + " " + greenTea.getPrice());
        Order cake = new DessertOrder("cake");
        cake.setStatus("CANCELED");
//        System.out.println(cake.getOrderNumber() + " " + cake.getPrice());
        OrderManager totalBill = new OrderManager();
        Order[] firstOrder = {latte, greenTea, cake};
        System.out.println(totalBill.eachOrderId(firstOrder));
        System.out.println("Total bill for all orders: UAH " + totalBill.calculateTotal(firstOrder));





//        ConsoleManager consoleManager = new ConsoleManager();
//
//
//        System.out.println(consoleManager.billGetter());

    }
}
