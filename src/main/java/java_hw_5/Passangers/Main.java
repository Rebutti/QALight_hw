package java_hw_5.Passangers;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("Kopiyka", 43);
        Car kia = new Car("Sportage", 100, 5);
        Truck bus = new Truck("Gazel", 200, 14.5);

        System.out.println(vehicle.move());
        System.out.println(vehicle.stop());

        System.out.println(kia.move());
        System.out.println(bus.move());
        System.out.println(kia.stop());
        System.out.println(bus.stop());
    }
}
